/*
 * Player
 * V1.3
 * Date: 20160528
 * Author: Björn Svensson
 * 
 */
package character;

import java.util.HashMap;
import java.util.Random;

/*
 * Class that represents the Player in the game
 */
public class Player extends Character {
	private HashMap<String, Integer> statsRef = new HashMap<>();
	private int maxhealth;
	private int MedGel = 3;
	private int itemChoice;

	/**
	 * Constructor for a basic player with 2's in every stat
	 */
	public Player() {
		int[] start = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
		setStats(start);
	}

	/**
	 * Constructor for a new player object
	 * 
	 * @param itemChoice
	 *            the set of items chosen for the character
	 * @param playerStats
	 *            the specific stats to be placed for a character
	 */
	public Player(int itemChoice, int[] playerStats) {
		this.setItemChoice(itemChoice);
		setStats(playerStats);
		setMaxhealth(getHealth());
		addMapKeys();
	}

	/**
	 * Method that applies the chosen item sets for the character
	 */
	public void applyItemEffect() {
		switch (itemChoice) {
		case 1:
			setPresence(getPresence() + 1);
			setManipulation(getManipulation() + 1);
			setComposure(getComposure() + 1);
			break;
		case 2:
			setStrength(getStrength() + 1);
			setDexterity(getDexterity() + 1);
			setStamina(getStamina() + 1);
			break;
		case 3:
			setIntelligence(getIntelligence() + 1);
			setWits(getWits() + 1);
			setResolve(getResolve() + 1);
		}

	}

	/**
	 * Method that puts references in a HashMap for easier access to specific
	 * stats during ability tests.
	 */
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

	/**
	 * Method that puts specific stats in the correct place
	 * 
	 * @param stats
	 *            the specific stats to be put on the player
	 */
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

	/**
	 * Method to retrieve all stats as an int[]
	 * 
	 * @return an int[] with all the stats for a character
	 */
	public int[] getStats() {
		int[] stats = new int[9];
		stats[0] = getIntelligence();
		stats[1] = getStrength();
		stats[2] = getPresence();
		stats[3] = getWits();
		stats[4] = getDexterity();
		stats[5] = getManipulation();
		stats[6] = getResolve();
		stats[7] = getStamina();
		stats[8] = getComposure();
		return stats;
	}

	/**
	 * Method to retrieve and quickly calculate two abilities
	 * 
	 * @param ability1
	 *            the first ability to be retrieved
	 * @param ability2
	 *            the second ability to be retrieved
	 * @return the sum of both abilities as an int
	 */
	public int retrieveStats(String ability1, String ability2) {
		return statsRef.get(ability1) + statsRef.get(ability2);
	}

	/**
	 * Method to save stats as a string instead of an in[] with , in between
	 * 
	 * @return a string of numbers, each representing an attribute
	 */
	public String saveStats() {
		String returner = "";
		int[] stats = getStats();
		for (int i = 0; i < stats.length; i++) {
			returner += stats[i];
			if (i + 1 != stats.length)
				returner += ",";
		}
		return returner;
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
}
