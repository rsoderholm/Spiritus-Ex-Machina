package character;

import java.util.HashMap;
import java.util.Random;

public class Player extends Character {
	private HashMap<String, Integer> statsRef = new HashMap<>();
	private int maxhealth;
	private int MedGel = 3;
	private int itemChoice;

	public Player(){
		int[] start = {2,2,2,2,2,2,2,2,2};
		setStats(start);
	}
	public Player(int itemChoice, int[] playerStats) {
		// super();

		this.setItemChoice(itemChoice);
		setStats(playerStats);
		setMaxhealth(getHealth());
		addMapKeys();
	}

	private void addMapKeys() {
		statsRef.put("int", getIntelligence());
		statsRef.put("str", getStrength());
		statsRef.put("pre", getPresence());
		statsRef.put("wts", getWits());
		statsRef.put("dex", getDexterity());
		statsRef.put("man", getManipulation());
		statsRef.put("res", getResolve());
		statsRef.put("sta", getStamina());
		statsRef.put("cmp", getComposure());
	}

	private void setStats(int[] stats) {
		setIntelligence(stats[0]);
		setStrength(stats[1]);
		setPresence(stats[2]);
		setWits(stats[3]);
		setDexterity(stats[4]);
		setManipulation(stats[5]);
		setResolve(stats[6]);
		setStamina(stats[7]);
		setComposure(stats[8]);
		setHealth((strength + stamina + resolve) * 2);
		maxhealth = getHealth();
	}
	public int[] getStats(){
		int[] stats = new int[9];
		stats[0]= getIntelligence();
		stats[1]=getStrength();
		stats[2]=getPresence();
		stats[3]=getWits();
		stats[4]=getDexterity();
		stats[5]=getManipulation();
		stats[6]=getResolve();
		stats[7]=getStamina();
		stats[8]=getComposure();
		return stats;
	}

	public int retrieveStats(String ability1, String ability2) {
		return statsRef.get(ability1) + statsRef.get(ability2);
	}

	public int getMaxhealth() {
		return maxhealth;
	}

	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}

	public int getMedGel() {
		return MedGel;
	}

	public void setMedGel(int nbrOfMedGel) {
		this.MedGel = nbrOfMedGel;
	}

	public int getItemChoice() {
		return itemChoice;
	}
	public void setItemChoice(int itemChoice) {
		this.itemChoice = itemChoice;
	}
	public String saveStats() {
		String returner = "";
		int[] stats = getStats();
		for (int i = 0; i < stats.length; i++) {
			returner+=stats[i];
			if(i+1 != stats.length)
				returner+=",";
		}
		return returner;
	}
}
