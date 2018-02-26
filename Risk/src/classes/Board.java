package classes;

/****************************************************************************
 * A class to hold the countries and display them on a board. This also has 
 * the logic to move and attack from one country to another
 ***************************************************************************/
public class Board {
	
	/**  */
	int turnNum;
	
	/**  */
	
	
	/****************************************************************************
	 * The constructor for the board class
	 ***************************************************************************/
	public Board() {
		turnNum = 0;
	}
	
	/****************************************************************************
	 * The constructor for the board class
	 ***************************************************************************/
	public Player attack(Player att, Player def, Country co) {
		Player winner = att;
		return winner;
	}
}