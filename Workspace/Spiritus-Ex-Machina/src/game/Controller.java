package game;

import character.Npc;
import character.Player;
import gui.Navscreen.GameGUI;
import gui.Navscreen.Script;

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
	//	private HashMap<String, String[]> navMap = new HashMap<>();
	private Script script;


	public Controller(){
		setPlayer(new Player());
		setNpc(new Npc());
		script = new Script(this);
		GUI = new GameGUI(this);
		GUI.init();

	}
	public Controller(Player player, Npc npc){
		setPlayer(player);
		setNpc(npc);
		script = new Script(this);
		GUI=new GameGUI(this);


	}

	public void startCombat(String nextConversation){
		setActiveCombat(new CombatSituation(nextConversation));
		script.combatScreen();
	}
	public void setupDialog(){
		getGUI().disableButtons();
		getGUI().setEventText(script.getCurrentDialog()[0]);
		for (int i = 1; i < script.getCurrentDialog().length; i+=2) {
			try{
				getGUI().setDialog(script.getCurrentDialog()[i], i, script.getCurrentDialog()[i+1]);
			}catch(NullPointerException e){};
		}
	}

	public void navigation(String navKey){
		navigation.get(navKey).run();
	}
	public void addNavigation(String key, Runnable value){
		navigation.put(key, value);
	}

	public void endCombat(){
		setActiveCombat(null);
	}
	public void gameOver(){
		setActiveCombat(null);
		getGUI().setEventText("GAME OVER!!!");
		navigation.put("Exit", () -> System.exit(0));
		getGUI().disableButtons();
		getGUI().setDialog("End Game", 1, "Exit");
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
	public void victorius(String victoryKey){
		setActiveCombat(null);
		navigation.get(victoryKey).run();
	}

	public class CombatSituation{
		private HashMap<String,Runnable> actions = new HashMap<>();
		private String victoryKey;
		public CombatSituation(String victoryKey){
			this.victoryKey=victoryKey;
			actions.put("h2h", () -> this.playerAction(1));
			actions.put("ranged", () -> this.playerAction(2));
//			actions.put("action3", ()-> this.playerAction(3));
//			actions.put("action4", ()-> this.playerAction(4));
		}
		public void setupCombatDialog(){
			getGUI().disableButtons();
			getGUI().setEventText(script.getCurrentDialog()[0]);
			for (int i = 1; i < script.getCurrentDialog().length; i+=2) {
				try{
					getGUI().setDialog(script.getCurrentDialog()[i], i, script.getCurrentDialog()[i+1]);
				}catch(NullPointerException e){};
			}
		}
		public void performCharacterAction(String action){
			actions.get(action).run();
		}
		public void playerAction(int choice){
			int result=0;
			switch(choice){
			case 1: 
				result=StatDice.rollDice(getPlayer().getStrength()+getPlayer().getDexterity()-getNpc().getStamina());
				break;
			case 2:
				result=StatDice.rollDice(getPlayer().getComposure()+getPlayer().getDexterity()-getNpc().getStamina());
				if(result>0)
					applyDamage(getNpc(), result);
				break;
			case 3:
				result=0;
				npcAction();
				break;
			case 4:
				result=0;
				npcAction();
				break;
			}
			if(result>0){
				if(applyDamage(getNpc(), result))
					checkVictor(getNpc());
				else
					npcAction();
			}
			else
				npcAction();
		}	
		public void npcAction(){
			int result = StatDice.rollDice(getNpc().getStrength()+getNpc().getDexterity()-getPlayer().getStamina());
			getGUI().setEventText(getNpc().getClass()+" attacks!");
			if(result>0){
				if(applyDamage(getPlayer(), result))
					checkVictor(getPlayer());
				else
					script.combatScreen();
			}
			else
				script.combatScreen();
		}



		public void checkVictor(Character chara){
				if(chara == getPlayer())
					gameOver();
				else
					victorius(victoryKey);
		}
		public boolean applyDamage(Character chara, int damage){
			chara.setHealth(chara.getHealth()-damage);
			if(chara== getPlayer())
				getGUI().changeHealth();
			if(chara.getHealth()<=0)
				return true;
			return false;
		}
	}


}




