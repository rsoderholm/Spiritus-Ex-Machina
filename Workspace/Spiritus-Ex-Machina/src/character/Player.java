package character;

import java.util.Random;

public class Player extends Character {
	
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
	public int getMaxhealth() {
		return maxhealth;
	}
	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}
}
