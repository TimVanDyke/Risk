package classes;

import java.util.ArrayList;

/****************************************************************************
 * A Class to hold the information on a player. Players have a kingdom which
 * is a dynamic list of countries they control, as well as a boolean inGame
 * which says if they have lost yet. They also have a name which is optional
 ***************************************************************************/
public class Player {
	
	/** a list of all the territories this player controls */
	private ArrayList<Country> kingdom;
	
	/** The player's name that is displayed */
	private String name;
	
	/** This is true until the player has no countries in their kingdom */
	private boolean inGame;
	
	/****************************************************************************
	 * A constructor for Player. 
	 * @param String Name: this sets the player's name
	 ***************************************************************************/
	public Player (String name) {
		this.kingdom = new ArrayList<Country>();
		this.inGame = true;
		this.name = name;
	}
	
	/****************************************************************************
	 * A constructor for Player. 
	 ***************************************************************************/
	public Player () {
		this.kingdom = new ArrayList<Country>();
		this.inGame = true;
		this.name = "nameless";
	}
	
	/****************************************************************************
	 * this is called when a player loses the game.  
	 ***************************************************************************/
	public void lose() {
		this.inGame = false;
	}

	/****************************************************************************
	 * This sends the entire kingdom of the player back to whoever called it
	 * FIXME I think I should add public methods to modify this as needed, not 
	 * give the whole array
	 * @return the kingdom
	 ***************************************************************************/
	public ArrayList<Country> getKingdom() {
		return kingdom;
	}

	/****************************************************************************
	 * Returns the player's name. 
	 * @return the name
	 ***************************************************************************/
	public String getName() {
		return name;
	}

	/****************************************************************************
	 * returns whether or not the player is still in the game
	 * @return the inGame
	 ***************************************************************************/
	public boolean isInGame() {
		return inGame;
	}
}
