package classes;

import java.util.Random;

/***************************************************************************
 * A class to create a Bot that can play against human players.
 ***************************************************************************/
public class Bot extends Player {
	
	/** the brain for the bot. */
	private Random rand;

	/***********************************************************************
	 * A constructor for Bot. 
	 * @param name this sets the bot's name.
	 **********************************************************************/
	public Bot(final String name) {
		super(name);
		rand = new Random();
	}
	
	/***********************************************************************
	 * A default constructor for bot. 
	 **********************************************************************/
	public Bot() {
		rand = new Random();
	}	
	
	/***********************************************************************
	 * A method to decide what the bot should do on a given turn.
	 * Returning -1 ends the turn
	 * Returning 1 will cause the bot to attack
	 * @return an int which will describe what to do
	 **********************************************************************/
	public int playTurn() {
		int choose = rand.nextInt(100) + 1;
		if (choose <= 25) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
	
	//choose random country to attack Maybe put this in board or
	/***********************************************************************
	 * Select a country to attack. Must be a neighbor of a
	 * country in a kingdom.
	 * @return a country
	 **********************************************************************/
	public Country selectAttack() {
		Country cn = new Country();
		int choose = rand.nextInt(kingdom.size());
		for (Country c : kingdom) {
			if (choose == kingdom.indexOf(c)) {
				int n = rand.nextInt(c.getNeighbors().length);
				Country[] neighbors = c.getNeighbors();
				cn = neighbors[n];
			}
		}
		return cn;
	}
	
}
