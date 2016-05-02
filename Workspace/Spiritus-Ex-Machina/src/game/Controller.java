package game;

import character.Npc;
import character.Player;
import gui.Navscreen.GameGUI;
import gui.Navscreen.Script;

import java.io.IOException;
import java.util.HashMap;

import character.Character;
/**
 * Kontrollern för spelets hantering av navigering, karaktärer och events.
 * @author Björn Svensson
 *
 */
public class Controller {
	private Player player;
	private Npc npc;
	private CombatSituation activeCombat;
	private GameGUI GUI;
	private HashMap<String, Runnable> navigation = new HashMap<>();
	private HashMap<String, String[]> navMap = new HashMap<>();
	private Script script;
	private FileTranslator translator;

	/**
	 * Startup for the controller class
	 * @throws IOException 
	 */
	public Controller() throws IOException{
		setPlayer(new Player());
		setNpc(new Npc());
//		script = new Script(this);
		translator = new FileTranslator(this);
		GUI = new GameGUI(this);
		GUI.init();

	}

	/**
	 * 
	 * @param player
	 * @param npc
	 * @throws IOException 
	 */
//	public Controller(Player player) throws IOException{
//		setPlayer(player);
//		setNpc(new Npc());
//			script = new Script(this);
//		GUI = new GameGUI(this);
//		GUI.init();
//	}
	public HashMap<String, String[]> getConversationNavigation(){
		return navMap;
	}
	public HashMap<String, Runnable> getNavigation(){
		return navigation;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Npc getNpc() {
		return npc;
	}
	public void setNpc(Npc npc) {
		this.npc = npc;
	}
	public GameGUI getGUI() {
		return GUI;
	}
	public CombatSituation getActiveCombat() {
		return activeCombat;
	}
	public void setActiveCombat(CombatSituation activeCombat) {
		this.activeCombat = activeCombat;
	}

	/**
	 * Initiation of a combat situation
	 * @param nextConversation The next conversation after combat is resolved
	 */
	public void startCombat(String nextConversation){
		setActiveCombat(new CombatSituation(nextConversation));
	}

	/**
	 * Sorts and updates the texts in the GUI class
	 * @param dialog The array with the different texts and keywords
	 */
	public void setupDialog(String[] dialog){
		getGUI().disableButtons();
		getGUI().setEventText(dialog[0]);
		for (int i = 1; i < dialog.length; i+=2) {
			try{
				getGUI().setDialog(dialog[i], i, dialog[i+1]);
			}catch(NullPointerException e){};
		}
	}

	/**
	 * Activation of the next conversation
	 * @param navKey the keyword for the hashMap
	 */
	public void navigation(String navKey){
		navigation.get(navKey).run();
	}

	/**
	 * Addition to the hashMap
	 * @param key the keyword
	 * @param value what method to be runned
	 */
	public void addNavigation(String key, Runnable value){
		navigation.put(key, value);
	}

	/**
	 * End of the game. A player never wants to be 
	 * here, ever.
	 * @param event The eventText to be updated.
	 */
	public void gameOver(String event){
		setActiveCombat(null);
		getGUI().setEventText(event);
		navigation.put("Exit", () -> System.exit(0));
		getGUI().disableButtons();
		getGUI().setDialog("End Game", 1, "Exit");
	}

	/**
	 * When the player is victorius
	 * @param victoryKey the next conversation
	 * @param event what the event text label will say
	 */
	public void victorius(String victoryKey, String event){
		setActiveCombat(null);
		getGUI().setEventText(event);
		getGUI().disableButtons();
		getGUI().setDialog("End combat", 1, victoryKey);
	}

	/**
	 * Interior class for handling all combat situation.
	 * @author bjorsven
	 *
	 */
	public class CombatSituation{

		private HashMap<String,Runnable> actions = new HashMap<>();
		private String victoryKey;
		private String eventText = "Combat is initiated!!!";

		/**
		 * constructor for combats with specific actions and 
		 * @param victoryKey the key for 
		 */
		public CombatSituation(String victoryKey){
			this.victoryKey=victoryKey;
			actions.put("h2h", () -> this.playerAction(1));
			actions.put("ranged", () -> this.playerAction(2));
			actions.put("heal", ()-> this.playerAction(3));
			actions.put("action4", ()-> this.playerAction(4));
			combatScreen(eventText);
		}

		/**
		 * method to change the combat dialogues.
		 * @param dialogues the array with the dialogues for combat actions
		 */
		public void setupCombatDialog(String[] dialogues){
			getGUI().disableButtons();
			getGUI().setEventText(dialogues[0]);
			for (int i = 1; i < dialogues.length; i+=2) {
				try{
					getGUI().setDialog(dialogues[i], i, dialogues[i+1]);
				}catch(NullPointerException e){};
			}
		}

		/**
		 * method to start an character action
		 * @param action which action that is going to be performed
		 */
		public void performCharacterAction(String action){
			actions.get(action).run();
		}

		/**
		 * Method used when updating the dialogue and buttons
		 * @param event the eventtext
		 */
		public void combatScreen(String event){
			String[] combatDialogues = new String[9];
			combatDialogues[0]= event;
			combatDialogues[1]="[STR + DEX] Hand to hand";
			combatDialogues[2]="h2h";
			combatDialogues[3]="[DEX + CMP] Ranged attack";
			combatDialogues[4]="ranged";
			combatDialogues[5]="[Consume Med-gel] Heal your wounds. ";
			combatDialogues[6]="heal";
			combatDialogues[7]=null;
			combatDialogues[8]=null;
			setupCombatDialog(combatDialogues);
		}

		/**
		 * method to perform which action the player chose
		 * @param choice which action that was used
		 */
		public void playerAction(int choice){
			int result=0;
			eventText = "";
			switch(choice){
			case 1: 
				eventText += "You attacked your opponent in hand-to-hand combat.";
				result=StatDice.rollDice(getPlayer().getStrength()+getPlayer().getDexterity()-getNpc().getStamina());
				break;
			case 2:
				eventText += "You aimed your gun and fired a bullet at your opponent.";
				result=StatDice.rollDice(getPlayer().getComposure()+getPlayer().getDexterity()-getNpc().getStamina());
				break;
			case 3:
				eventText += "You mended your wounds";
				getPlayer().setHealth(getPlayer().getMaxhealth());
				getGUI().changeHealth();
				result=0;
				break;
			case 4:
				eventText += "";
				result=0;
				break;
			}
			if(result>0){
				eventText += "\n\n Your opponent suffered " + result + " points of damage";
				if(applyDamage(getNpc(), result))
					checkVictor(getNpc());
				else
					npcAction();
			}
			else{
				if(choice == 3)
					eventText += "\n\n Your health has been restored";
				else
					eventText += "\n\n You missed!";
				npcAction();
			}
		}	

		/**
		 * Whenever a player action fail to defeat the opponent, the opponent attacks
		 */
		public void npcAction(){
			eventText += "\n\n The enemy attacks you with their fists!";
			int result = StatDice.rollDice(getNpc().getStrength()+getNpc().getDexterity()-getPlayer().getStamina());
			getGUI().setEventText(getNpc().getClass()+" attacks!");
			if(result>0){
				eventText += "\n\n You recieved " + result + " points of damage";
				if(applyDamage(getPlayer(), result))
					checkVictor(getPlayer());
				else
					combatScreen(eventText);
			}
			else{
				eventText += "\n\n Their attack missed!";
				combatScreen(eventText);
			}
		}

		/**
		 * Method to check if a character is defeated
		 * @param chara the character that gets checked
		 */
		public void checkVictor(Character chara){
			if(chara == getPlayer()){
				eventText += "\n\n You Died!";
				gameOver(eventText);
			}else{
				eventText += "\n\n You have defeated your opponent!";
				victorius(victoryKey, eventText);
			}
		}

		/**
		 * Whenever a character is damaged (result of rolls is above 0)
		 * damage will be applied to associated character
		 * @param chara the character on which the damage will be applied to
		 * @param damage the amount of damage to be applied
		 * @return boolean result if a character is defeated or not
		 */
		public boolean applyDamage(Character chara, int damage){
			chara.setHealth(chara.getHealth()-damage);
			if(chara== getPlayer())
				getGUI().changeHealth();
			if(chara.getHealth()<=0)
				return true;
			return false;
		}
	}

	public class AbilityTester{

		public AbilityTester(){

		}
	}
}




