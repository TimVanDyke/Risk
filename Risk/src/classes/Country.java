package classes;

/****************************************************************************
 * A class to hold the logic for countries. Countries have a name and a
 * player who owns them, as well as the ability to change their owner to a
 * player who conquers it. Also, countries will hold number of units present
 * and be able to return how many units there are.
 ***************************************************************************/
public class Country {

	/** The player that has this country in it's kingdom. */
	private Player owner;

	/** the name of the country. */
	private String name;

	/** the number of units in this country. */
	private int numUnits;

	/** This country's neighbors. */
	private Country[] neighbors;

	/** this country's sprite. */
	private Sprite sprite;
	
	

	/***********************************************************************
	 * the constructor for Country. This sets owner to null, numUnits to 0, 
	 * and name to what they are instantiated as. This is the constructor
	 * for countries with one neighbor.
	 * @param name the name of the country.
	 * @param size the size of the country.
	 * @param path the path to the sprite.
	 **********************************************************************/
	public Country(final String name, final int size, final String path) {
		owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[size];
		sprite = new Sprite(path);
	}
	
	/***********************************************************************
	 * Default constructor to be used for our tests.
	 * @param name for the country
	 * @param size of the country
	 **********************************************************************/
	public Country(final String name, final int size) {
		owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[size];
	}
	
	/***********************************************************************
	 * Default constructor to be used for our tests.
	 **********************************************************************/
	public Country() {
		
	}
	
	/***********************************************************************
	 * used by the board to check who owns a country.
	 * @return the owner.
	 **********************************************************************/
	public Player getOwner() {
		return owner;
	}

	/***********************************************************************
	 * used by the board to set who owns a country.
	 * @param o the owner to set.
	 **********************************************************************/
	public void setOwner(final Player o) {
		owner = o;
	}

	/***********************************************************************
	 * used by board to check the number of units in a country.
	 * @return the numUnits.
	 **********************************************************************/
	public int getNumUnits() {
		return numUnits;
	}

	/***********************************************************************
	 * used by board to set numUnits in a country.
	 * @param mod : "add" means add units, "sub" means subtract units.
	 * @param change : the number of units to add or subtract.
	 **********************************************************************/
	public void setNumUnits(final String mod, final int change) {
		if (mod.equals("add")) {
			numUnits = numUnits + change;
		} else if (mod.equals("sub")) {
			numUnits = numUnits - change;
		} else {
			System.out.println("Please type \"add\" or \"sub\"");
		}
	}
	
	/***********************************************************************
	 * used by board to set numUnits in a country.
	 * @param numUnits the number of units to set this.numUnits to.
	 **********************************************************************/
	public void setNumUnits(final int numUnits) {
		this.numUnits = numUnits;
	}

	/***********************************************************************
	 * Used to iterate through neighbors to give options after 
	 * selecting a country.
	 * @return the neighbors.
	 **********************************************************************/
	public Country[] getNeighbors() {
		return neighbors;
	}
	
	/***********************************************************************
	 * Adds two neighbors to the selected country.
	 * @param n1 : a neighbor.
	 * @param n2 : a neighbor.
	 **********************************************************************/
	public void addTwoNeighbors(final Country n1, final Country n2) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		return;
	}
	
	/***********************************************************************
	 * Adds two neighbors to the selected country.
	 * @param n1 : a neighbor.
	 * @param n2 : a neighbor.
	 * @param n3 : a neighbor.
	 **********************************************************************/
	public void addThreeNeighbors(final Country n1, final Country n2, 
			final Country n3) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		neighbors[2] = n3;
		return;
	}
	
	/***********************************************************************
	 * Adds two neighbors to the selected country.
	 * @param n1 : a neighbor.
	 * @param n2 : a neighbor.
	 * @param n3 : a neighbor.
	 * @param n4 : a neighbor.
	 **********************************************************************/
	public void addFourNeighbors(final Country n1, final Country n2, 
			final Country n3, final Country n4) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		neighbors[2] = n3;
		neighbors[3] = n4;
		return;
	}
	
	/***********************************************************************
	 * Adds two neighbors to the selected country.
	 * @param n1 : a neighbor.
	 * @param n2 : a neighbor.
	 * @param n3 : a neighbor.
	 * @param n4 : a neighbor.
	 * @param n5 : a neighbor.
	 **********************************************************************/
	public void addFiveNeighbors(final Country n1, final Country n2, 
			final Country n3, final Country n4, final Country n5) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		neighbors[2] = n3;
		neighbors[3] = n4;
		neighbors[4] = n5;
		return;
	}
	
	/***********************************************************************
	 * Adds two neighbors to the selected country.
	 * @param n1 : a neighbor.
	 * @param n2 : a neighbor.
	 * @param n3 : a neighbor.
	 * @param n4 : a neighbor.
	 * @param n5 : a neighbor.
	 * @param n6 : a neighbor.
	 **********************************************************************/
	public void addSixNeighbors(final Country n1, final Country n2, 
			final Country n3, final Country n4, final Country n5, 
			final Country n6) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		neighbors[2] = n3;
		neighbors[3] = n4;
		neighbors[4] = n5;
		neighbors[5] = n6;
		return;
	}
	
	/***********************************************************************
	 * @return name: the name of the country.
	 **********************************************************************/
	public String getName() {
		return name;
	}
	
	/***********************************************************************
	 * @return sprite: this country's sprite.
	 **********************************************************************/
	public Sprite getSprite() {
		return sprite;
	}
}