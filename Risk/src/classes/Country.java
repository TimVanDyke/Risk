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
	
	/****************************************************************************
	 * the constructor for Country. This sets Owner to null, numUnits to 0, and 
	 * name to what they are instantiated as. This is the constructor for 
	 * countries with one neighbor
	 * @param name: the name of the country
	 * @param c1: the neighbor
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
	 * @return name: the name of the country
	 ***************************************************************************/
	public String getName() {
		return name;
	}
	
}