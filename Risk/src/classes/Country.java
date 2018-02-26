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
	public Country(String name, Country c1) {
		Owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[1];
		neighbors[0] = c1;
	}
	
	/****************************************************************************
	 * the constructor for Country. This sets Owner to null, numUnits to 0, and 
	 * name to what they are instantiated as. This is the constructor for 
	 * countries with two neighbors
	 * @param name: the name of the country
	 * @param c1: the first neighbor
	 * @param c2: the second neighbor
	 ***************************************************************************/
	public Country(String name, Country c1, Country c2) {
		Owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[2];
		neighbors[0] = c1;
		neighbors[1] = c2;
	}
	
	/****************************************************************************
	 * the constructor for Country. This sets Owner to null, numUnits to 0, and 
	 * name to what they are instantiated as. This is the constructor for 
	 * countries with three neighbors
	 * @param name: the name of the country
	 * @param c1: the first neighbor
	 * @param c2: the second neighbor
	 * @param c3: the third neighbor
	 ***************************************************************************/
	public Country(String name, Country c1, Country c2, Country c3) {
		Owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[3];
		neighbors[0] = c1;
		neighbors[1] = c2;
		neighbors[2] = c3;
	}
	
	/****************************************************************************
	 * the constructor for Country. This sets Owner to null, numUnits to 0, and 
	 * name to what they are instantiated as. This is the constructor for 
	 * countries with four neighbors
	 * @param name: the name of the country
	 * @param c1: the first neighbor
	 * @param c2: the second neighbor
	 * @param c3: the third neighbor
	 * @param c4: the fourth neighbor
	 ***************************************************************************/
	public Country(String name, Country c1, Country c2, Country c3, Country c4) {
		Owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[4];
		neighbors[0] = c1;
		neighbors[1] = c2;
		neighbors[2] = c3;
		neighbors[3] = c4;
	}
	
	/****************************************************************************
	 * the constructor for Country. This sets Owner to null, numUnits to 0, and 
	 * name to what they are instantiated as. This is the constructor for 
	 * countries with five neighbors
	 * @param name: the name of the country
	 * @param c1: the first neighbor
	 * @param c2: the second neighbor
	 * @param c3: the third neighbor
	 * @param c4: the fourth neighbor
	 * @param c5: the fifth neighbor
	 ***************************************************************************/
	public Country(String name, Country c1, Country c2, Country c3, Country c4, Country c5) {
		Owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[5];
		neighbors[0] = c1;
		neighbors[1] = c2;
		neighbors[2] = c3;
		neighbors[3] = c4;
		neighbors[4] = c5;
	}

	/****************************************************************************
	 * the constructor for Country. This sets Owner to null, numUnits to 0, and 
	 * name to what they are instantiated as. This is the constructor for 
	 * countries with six neighbors
	 * @param name: the name of the country
	 * @param c1: the first neighbor
	 * @param c2: the second neighbor
	 * @param c3: the third neighbor
	 * @param c4: the fourth neighbor
	 * @param c5: the fifth neighbor
	 * @param c6: the sixth neighbor
	 ***************************************************************************/
	public Country(String name, Country c1, Country c2, Country c3, Country c4, Country c5, Country c6) {
		Owner = null;
		numUnits = 0;
		this.name = name;
		neighbors = new Country[6];
		neighbors[0] = c1;
		neighbors[1] = c2;
		neighbors[2] = c3;
		neighbors[3] = c4;
		neighbors[4] = c5;
		neighbors[5] = c6;
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
	 * @return name: the name of the country
	 ***************************************************************************/
	public String getName() {
		return name;
	}
	
}