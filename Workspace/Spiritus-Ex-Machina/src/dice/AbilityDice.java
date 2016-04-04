package dice;

import java.util.Random;

import spiritus.Dice;

public class AbilityDice extends Dice{
	private int amount;
	private int successes=0;
	private int advantages=0;
	private Random random = new Random();

	public AbilityDice() {
		amount = 1;
	}
	public AbilityDice(int amount){
		if(amount>=1)
			this.amount=amount;
		else
			this.amount=1;
	}
	public int rollDice(int amount){
		successes=0;
		int result=0;
		for(int i=0; i<amount;i++){
			result=random.nextInt(10)+1;
			if(result>=8){
				if(result==10)
					amount++;
				successes++;
			}
		}
		return result;
	}
	public int getSuccesses(){
		return successes;
	}
	public int getAdvantages(){
		return advantages;
	}

}
