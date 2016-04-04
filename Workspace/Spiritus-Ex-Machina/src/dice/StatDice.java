package dice;

import java.util.Random;

public class StatDice{

	public static int rollDice(int amount){
		int successes=0;
		int result=0;
		if(amount<1)
			amount=1;
		for(int i=0; i<amount;i++){
			result=new Random().nextInt(10)+1;
			if(result>=8){
				if(result==10)
					amount++;
				successes++;
			}
		}
		return successes;
	}
}
