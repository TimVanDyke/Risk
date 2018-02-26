package classes;

public class Main {
	
	private Main() {
		Die die1 = new Die();
		int roll = 1;
		int numRoll = 0;
		while (numRoll < 100) {
			roll = die1.Roll();
			System.out.println("Roll " + numRoll + ": " + roll);
			if(roll < 1 || roll > 6){
				System.
			}
			numRoll++;
		}
	}
}
//hi tim