/*
 *  StatDice
 * V1.0
 * Date: 20160410
 * Author: Bj�rn Svensson
 */
package game;

import java.util.Random;

public final class StatDice {

	/**
	 * Class that represents the D10 dice in the game
	 * 
	 * @param amount
	 *            how many dices to be rolled
	 * @return the number of successes from the rolls
	 */
	public static int rollDice(int amount) {
		int successes = 0;
		int result = 0;

		if (amount < 1) {
			amount = 1;
		}
		
		for (int i = 0; i < amount; i++) {
			result = new Random().nextInt(10) + 1;
			if (result >= 8) {
				if (result == 10)
					amount++;
				successes++;
			}
		}
		return successes;
	}
}
