package classes;

/****************************************************************************
 * A class to initialize everything, then had it all off to the GUI
 ***************************************************************************/
public class Main {
	
	/** the width of the screen */
	private int width;
	
	/** the height of the screen */
	private int height;
	
	private Board board;
	
	private screen 
	
	public Main() {
		height = 1;
	}
	public static void main(String[] args) {
		Die die1 = new Die();
		int roll = 1;
		int numRoll = 0;
		while (numRoll < 100) {
			roll = die1.Roll();
			System.out.println("Roll " + numRoll + ": " + roll);
			if(roll < 1 || roll > 6){
				System.out.println("I hate myself");
			}
			numRoll++;
		}
		
	}
}