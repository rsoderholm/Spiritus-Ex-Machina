/*
 * Npc
 * V1.3
 * Date: 20160415
 * Author: Björn Svensson
 */
package character;

import java.util.Random;

/*
 * Class that extends character to an NPC
 * with specific ways for creation
 */
public class Npc extends Character {

	/**
	 * Constructor that creates an Npc with random stats
	 */
	public Npc() {
		int[] stats = new int[9];
		Random random = new Random();
		for (int i = 0; i < 9; i++) {
			stats[i] = random.nextInt(3) + 1;
		}
		setRandomStats(stats);
	}

	/**
	 * method that applies the stats to the character
	 * 
	 * @param stats
	 *            the specific attributes to be set on the npc
	 */
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
		setHealth((strength + stamina + resolve) * 2);
	}
}