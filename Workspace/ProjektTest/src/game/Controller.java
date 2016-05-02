package game;

import character.Npc;
import character.Player;
import gui.Navscreen.JavaFxTest;
import gui.Navscreen.Script;

import java.util.HashMap;

import character.Character;

public class Controller {
	private Player player;
	private Npc npc;
	private CombatSituation activeCombat;
	private JavaFxTest GUI;
	private HashMap<String, Runnable> navigation = new HashMap<>();
	private Script script;


	public Controller(){
		setPlayer(new Player());
		this.npc = new Npc();
		GUI = new JavaFxTest(this);
		script = new Script(this);
	}
	public Controller(Player player, Npc npc){
		this.setPlayer(player);
		this.npc=npc;
		GUI = new JavaFxTest(this);
		script = new Script(this);

	}

	public void startCombat(){
		activeCombat = new CombatSituation();


	}

	public void navigation(String navKey){
		navigation.get(navKey).run();
	}
	public void addNavigation(String key, Runnable value){
		navigation.put(key, value);
	}

	public void endCombat(){

	}
	public void gameOver(){
	}
	public JavaFxTest getGUI(){
		return GUI;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	private class CombatSituation{
		private HashMap<String,Runnable> actions;
		public CombatSituation(){
			actions.put("h2h", () -> this.playerAction(1));
			actions.put("ranged", () -> this.playerAction(2));

		}
		public void playerAction(int choice){
			int result;
			switch(choice){
			case 1: 
				result=StatDice.rollDice(getPlayer().getStrength()+getPlayer().getDexterity()-npc.getStamina());
				if(result>0)
					applyDamage(npc, result);
				break;
			case 2:
				result=StatDice.rollDice(getPlayer().getComposure()+getPlayer().getDexterity()-npc.getStamina());
				if(result>0)
					applyDamage(npc, result);
				break;
			case 3:
				result=0;
				break;
			case 4:
				result=0;
				break;
			}

		}
	}	
	public void npcAction(){

	}
	public void victorius(){
	}

	public void applyDamage(Character chara, int damage){
		chara.setHealth(chara.getHealth()-damage);
		if(chara.getHealth()<=0)
			if(chara == getPlayer())
				gameOver();
			else
				victorius();
	}

}




