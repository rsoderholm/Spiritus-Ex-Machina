package dice;

import java.util.Random;

import spiritus.Dice;

public class DifficulityDice extends Dice{
	private int amount;
	private int failures=0;
	private int disadvantages=0;
	private Random random = new Random();

	public DifficulityDice() {
		amount = 1;
	}
	public DifficulityDice(int amount){
		if(amount>=1)
			this.amount=amount;
		else
			this.amount=1;
	}
	public int rollDice(){
		failures=0;
		int result=0;
		for(int i=0; i<amount;i++){
			result=random.nextInt(10)+1;
			if(result>=8){
				if(result==10)
					amount++;
				failures++;
			}
		}
		return result;
	}
	public int getFailures(){
		return failures;
	}
	public int getDisadvantages(){
		return disadvantages;
	}
}
