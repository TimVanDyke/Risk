package classes;

import java.util.Random;

public class Dice {
	
	/** the minimum allowed roll that can be gotten in our game of risk */
	private int minRoll;
	
	/** the maximum allowed roll that can be gotten in our game of risk */
	private int maxRoll;
	
	/** the random number generator for the dice */
	private Random rand;
	/****************************************************************************
	 * A constructor for our dice class. One bject of this class's type are going 
	 * to be created in the main method to roll the dice. 
	 * @param int minRoll: the minimum roll possible on the dice
	 * @param int maxRoll: the maximum roll possible on the dice
	 ***************************************************************************/
	public Dice(int minRoll, int maxRoll) {
		this.minRoll = minRoll;
		this.maxRoll = maxRoll;
		rand = new Random();
	}
	
	/****************************************************************************
	 * A constructor for our dice class. One bject of this class's type are going 
	 * to be created in the main method to roll the dice. 
	 * This is the default constructor so there are no parameters
	 ***************************************************************************/
	public Dice() {
		this.minRoll = 2;
		this.maxRoll = 12;
		rand = new Random();
	}
	
	/****************************************************************************
	 * This method "rolls the dice" and gives an integer that is from minRoll
	 * to maxRoll inclusive on both sides.
	 * @return int: a number from minRoll to maxRoll inclusive
	 ***************************************************************************/
	public int Roll() {
		return (rand.nextInt(maxRoll - minRoll) + minRoll);
	}
}
