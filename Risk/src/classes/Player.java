package classes;

import java.util.ArrayList;

/****************************************************************************
 * A Class to hold the information on a player. Players have a kingdom which
 * is a dynamic list of countries they control, as well as a boolean inGame
 * which says if they have lost yet. They also have a name which is optional.
 ***************************************************************************/
public class Player {
	
	/** a list of all the territories this player controls */
	private ArrayList<Country> kingdom;
	
	/** The player's name that is displayed */
	private String name;
	
	/** This is true until the player has no countries in their kingdom */
	private boolean inGame;
	
	/** This is false until the player's kingdom is the entire world*/
	private boolean winner;
	
	/****************************************************************************
	 * A constructor for Player. 
	 * @param String Name: this sets the player's name.
	 ***************************************************************************/
	public Player (String name) {
		this.kingdom = new ArrayList<Country>();
		this.inGame = true;
		this.name = name;
		this.winner = false;
	}
	
	/****************************************************************************
	 * A constructor for Player. 
	 ***************************************************************************/
	public Player () {
		this.kingdom = new ArrayList<Country>();
		this.inGame = true;
		this.name = "blank";
		this.winner = false;
	}
	
	/****************************************************************************
	 * this is called when a player loses the game.  
	 ***************************************************************************/
	public void lose() {
		this.inGame = false;
	}
	
	/****************************************************************************
	 * this is called when a player wins the game.  
	 ***************************************************************************/
	public void winner() {
		this.winner = true;
	}

	/****************************************************************************
	 * Adds a country to the player's kingdom.
	 * @param Country country: the country to add.
	 ***************************************************************************/
	public void addCountry(Country country) {
		kingdom.add(country);
	}

	/****************************************************************************
	 * Adds a country to the player's kingdom.
	 * @param Country country: the country to add.
	 ***************************************************************************/
	public void removeCountry(Country country) {
		int rem = -1;
		for (int i = 0; i < kingdom.size(); i++) {
			if (kingdom.get(i).getName() == country.getName()) {
				rem = i;
			}
		}
		if (rem == -1)
			System.out.println(country.getName() + "isn't in this player's kingdom");
		kingdom.remove(rem);
	}

	/****************************************************************************
	 * Returns the player's name. 
	 * @return the name.
	 ***************************************************************************/
	public String getName() {
		return name;
	}

	/****************************************************************************
	 * returns whether or not the player is still in the game.
	 * @return the inGame.
	 ***************************************************************************/
	public boolean isInGame() {
		return inGame;
	}

	/****************************************************************************
	 * returns size of the kingdom.
	 * @return int: size of kingdom.
	 ***************************************************************************/
	public int getKingdomSize() {
		return kingdom.size();
	}

	
}
