package classes;

/****************************************************************************
 * A class to hold the logic for countries. Countries have a name and a 
 * player who owns them, as well as the ability to change their owner to a 
 * player who conquers it. Also, countries will hold number of units present
 * and be able to return how many units there are. 
 ***************************************************************************/
public class Country {
	
	/** The player that has this country in it's kingdom */
	Player Owner;
	
	/** the name of the country */
	String name;
	
	/** the number of units in this country */
	int numUnits;
	
	/** This country's neighbors */
	private Country[] neighbors;
	
	/** this country's sprite */
	Sprite sprite;
	
	/****************************************************************************
	 * the constructor for Country. This sets Owner to null, numUnits to 0, and 
	 * name to what they are instantiated as. This is the constructor for 
	 * countries with one neighbor
	 * @param name: the name of the country
	 * @param size: the size of the country
	 * @param path: the path to the sprite
	 ***************************************************************************/
	public Country(String name, int size, String path) {
		Owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[size];
		sprite = new Sprite(path);
	}
	
	/****************************************************************************
	 * Default constructor
	 ***************************************************************************/
	public Country(String name, int size) {
		Owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[size];
	}
	
	/****************************************************************************
	 * used by the board to check who owns a country
	 * @return the owner
	 ***************************************************************************/
	public Player getOwner() {
		return Owner;
	}

	/****************************************************************************
	 * used by the board to set who owns a country
	 * @param owner the owner to set
	 ***************************************************************************/
	public void setOwner(Player owner) {
		Owner = owner;
	}

	/****************************************************************************
	 * used by board to check the number of units in a country
	 * @return the numUnits
	 ***************************************************************************/
	public int getNumUnits() {
		return numUnits;
	}

	/****************************************************************************
	 * used by board to set numUnits in a country
	 * @param String mod: "add" means add units, "sub" means subtract units
	 * @param int change the number of units to add or subtract
	 ***************************************************************************/
	public void setNumUnits(String mod, int change) {
		if (mod == "add")
			numUnits = numUnits + change;
		else if (mod == "sub")
			numUnits = numUnits - change;
		else {
			System.out.println("I think you mistyped \"add\" or \"sub\"");
		}
	}
	
	/****************************************************************************
	 * used by board to set numUnits in a country
	 * @param numUnits: the number of units to set this.numUnits to
	 ***************************************************************************/
	public void setNumUnits(int numUnits) {
		this.numUnits = numUnits;
	}

	/****************************************************************************
	 * Used to iterate through neighbors to give options after 
	 * selecting a country
	 * @return the neighbors
	 ***************************************************************************/
	public Country[] getNeighbors() {
		return neighbors;
	}
	
	/****************************************************************************
	 * Adds two neighbors to the selected country
	 * @param Country n1: a neighbor
	 * @param Country n2: a neighbor
	 ***************************************************************************/
	public void addTwoNeighbors(Country n1, Country n2) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		return;
	}
	
	/****************************************************************************
	 * Adds two neighbors to the selected country
	 * @param Country n1: a neighbor
	 * @param Country n2: a neighbor
	 * @param Country n3: a neighbor
	 ***************************************************************************/
	public void addThreeNeighbors(Country n1, Country n2, Country n3) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		neighbors[2] = n3;
		return;
	}
	
	/****************************************************************************
	 * Adds two neighbors to the selected country
	 * @param Country n1: a neighbor
	 * @param Country n2: a neighbor
	 * @param Country n3: a neighbor
	 * @param Country n4: a neighbor
	 ***************************************************************************/
	public void addFourNeighbors(Country n1, Country n2, Country n3, Country n4) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		neighbors[2] = n3;
		neighbors[3] = n4;
		return;
	}
	
	/****************************************************************************
	 * Adds two neighbors to the selected country
	 * @param Country n1: a neighbor
	 * @param Country n2: a neighbor
	 * @param Country n3: a neighbor
	 * @param Country n4: a neighbor
	 * @param Country n5: a neighbor
	 ***************************************************************************/
	public void addFiveNeighbors(Country n1, Country n2, Country n3, Country n4, Country n5) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		neighbors[2] = n3;
		neighbors[3] = n4;
		neighbors[4] = n5;
		return;
	}
	
	/****************************************************************************
	 * Adds two neighbors to the selected country
	 * @param Country n1: a neighbor
	 * @param Country n2: a neighbor
	 * @param Country n3: a neighbor
	 * @param Country n4: a neighbor
	 * @param Country n5: a neighbor
	 * @param Country n6: a neighbor
	 ***************************************************************************/
	public void addSixNeighbors(Country n1, Country n2, Country n3, Country n4, Country n5, Country n6) {
		neighbors[0] = n1;
		neighbors[1] = n2;
		neighbors[2] = n3;
		neighbors[3] = n4;
		neighbors[4] = n5;
		neighbors[5] = n6;
		return;
	}
	
	/****************************************************************************
	 * @return name: the name of the country
	 ***************************************************************************/
	public String getName() {
		return name;
	}
	
	/****************************************************************************
	 * @return sprite: this country's sprite
	 ***************************************************************************/
	public Sprite getSprite() {
		return sprite;
	}
}