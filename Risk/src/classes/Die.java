package classes;

import java.util.Random;

/****************************************************************************
 * A class to roll create dice for the game to use. This an instance of this
 * class will be used in the main method so players can roll dice.
 ***************************************************************************/
public class Die {
	
	/** the minimum allowed roll that can be gotten in our game of risk */
	private int minRoll;
	
	/** the maximum allowed roll that can be gotten in our game of risk */
	private int maxRoll;
	
	/** the random number generator for the dice */
	private Random rand;
	
	/****************************************************************************
	 * A constructor for our dice class. One object of this class's type are going 
	 * to be created in the main method to roll the dice. 
	 * @param int minRoll: the minimum roll possible on the dice.
	 * @param int maxRoll: the maximum roll possible on the dice.
	 ***************************************************************************/
	public Die(int minRoll, int maxRoll) {
		this.minRoll = minRoll;
		this.maxRoll = maxRoll + 1;
		rand = new Random();
	}
	
	/****************************************************************************
	 * A constructor for our dice class. One object of this class's type are going 
	 * to be created in the main method to roll the dice. 
	 * This is the default constructor so there are no parameters.
	 ***************************************************************************/
	public Die() {
		this.minRoll = 1;
		this.maxRoll = 7;
		rand = new Random();
	}
	
	/****************************************************************************
	 * This method "rolls the dice" and gives an integer that is from minRoll
	 * to maxRoll inclusive on both sides.
	 * @return int: a number from minRoll to maxRoll inclusive.
	 ***************************************************************************/
	public int Roll() {
		return (rand.nextInt(maxRoll - minRoll) + minRoll);
	}
}
