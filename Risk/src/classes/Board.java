package classes;

/****************************************************************************
 * A class to hold the countries and dice. This also has 
 * the logic to move and attack from one country to another
 ***************************************************************************/
public class Board {
	
	/** the number of turns played */
	int turnNum;
	
	/** The world */
	private Country[] World;
	
	/** the dice for the attacker */
	private Die[] att;
	
	/** the dice for the defender */
	private Die[] def;
	
	/****************************************************************************
	 * The constructor for the board class
	 ***************************************************************************/
	public Board() {
		
		//instantiating turnNumber
		turnNum = 0;
		
		//instantiating attacker and defender dice
		att = new Die[3];
		def = new Die[2];
		
		
		//adding all the countries to the world
		World = new Country[42];
	}
	
	/****************************************************************************
	 * The constructor for the board class
	 ***************************************************************************/
	public Player attack(Player att, Player def, Country co) {
		Player winner = att;
		return winner;
	}
}