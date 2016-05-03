package character;

import java.util.HashMap;
import java.util.Random;

public class Player extends Character {
	private HashMap<String, Integer> statsRef = new HashMap<>();
	private int maxhealth;
	public Player(){
		//		super();

		int[] stats = new int[9];
		Random random = new Random();
		for (int i = 0; i < 9; i++) {
			stats[i] = random.nextInt(3)+2;
		}
		setRandomStats(stats);
		setMaxhealth(getHealth());
		addMapKeys();
	}

	private void addMapKeys(){
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
	private void setRandomStats(int[] stats) {
		setIntelligence(stats[0]);
		setStrength(stats[1]);
		setPresence(stats[2]);
		setWits(stats[3]);
		setDexterity(stats[4]);
		setManipulation(stats[5]);
		setResolve(stats[6]);
		setStamina(stats[7]);
		setComposure(stats[8]);
		setHealth((strength + stamina + resolve)*2);
	}

	public int retrieveStats(String ability1, String ability2){
		return statsRef.get(ability1)+statsRef.get(ability2);
	}
	public int getMaxhealth() {
		return maxhealth;
	}
	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}
}
