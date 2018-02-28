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
	
	/****************************************************************************
	 * Initializes all countries
	 ***************************************************************************/
	private void intializeCountries(){
		//North America
		Country Alaska = new Country("Alaska", 3);
		Country NorthwestTerritory = new Country("Northwest Territory", 4);
		Country Greenland = new Country("Greenland", 4);
		Country Alberta = new Country("Alberta", 4);
		Country Ontario = new Country("Ontario", 6);
		Country Quebec = new Country("Quebec", 3);
		Country EasternUS = new Country("Eastern United States", 4);
		Country WesternUS = new Country("Western United States", 4);
		Country CentralAmerica = new Country("Central America", 3);
		
		//South America
		Country Venezuela = new Country("Venezuela", 3);
		Country Peru = new Country("Peru", 3);
		Country Argentina = new Country("Argentina", 2);
		Country Brazil = new Country("Brazil", 4);
		
		//Europe
		Country Iceland = new Country("Iceland", 3);
		Country GreatBritain = new Country("Great Britain", 4);
		Country NorthernEurope = new Country("Northern Europe", 5);
		Country Scandinavia = new Country("Scandinavia", 4);
		Country WesternEurope = new Country("Western Europe", 4);
		Country SouthernEurope = new Country("Southern Europe", 6);
		Country Ukraine = new Country("Ukraine", 6);
		
		//Africa
		Country NorthAfrica = new Country("North Africa", 6);
		Country Egypt = new Country("Egypt", 4);
		Country EastAfrica = new Country("East Africa", 6);
		Country Congo = new Country("Congo", 3);
		Country SouthAfrica = new Country("South Africa", 3);
		Country Madagascar = new Country("Madagascar", 2);
		
		//Asia
		Country MiddleEast = new Country("Middle East", 6);
		Country Afghanistan = new Country("Afghanistan", 5);
		Country Ural = new Country("Ural", 3);
		Country Siberia = new Country("Siberia", 5);
		Country Yakutsk = new Country("Yakutsk", 3);
		Country Irkutsk = new Country("Irkutsk", 4);
		Country Japan = new Country("Japan", 2);
		Country Mongolia = new Country("Mongolia", 5);
		Country China = new Country("China", 6);
		Country India = new Country("India", 4);
		Country Kamchatka = new Country("Kamchatka", 5);
		Country Siam = new Country("Siam", 3);
		
		//Australia
		Country Indonesia = new Country("Indonesia", 3);
		Country NewGuinea = new Country("New Guinea", 3);
		Country WesternAustralia = new Country("Western Australia", 3);
		Country EasternAustralia = new Country("Eastern Australia", 2);
		
		//Add neighbors for North America
		Alaska.addThreeNeighbors(NorthwestTerritory, Alberta, Kamchatka);
		NorthwestTerritory.addFourNeighbors(Alaska, Greenland, Alberta, Ontario);
		Greenland.addFourNeighbors(Iceland, Quebec, Ontario, NorthwestTerritory);
		Alberta.addFourNeighbors(Alaska, NorthwestTerritory, Ontario, WesternUS);
		Ontario.addSixNeighbors(NorthwestTerritory, Greenland, Quebec, EasternUS, WesternUS, Alberta);
		Quebec.addThreeNeighbors(Greenland, Ontario, EasternUS);
		EasternUS.addFourNeighbors(CentralAmerica, Quebec, Ontario, WesternUS);
		WesternUS.addFourNeighbors(CentralAmerica, Alberta, EasternUS, Ontario);
		CentralAmerica.addThreeNeighbors(Venezuela, WesternUS, EasternUS);
		
		//Add neighbors for South America
		Venezuela.addThreeNeighbors(CentralAmerica, Peru, Brazil);
		Peru.addThreeNeighbors(Venezuela, Brazil, Argentina);
		Brazil.addFourNeighbors(Venezuela, Peru, Argentina, NorthAfrica);
		Argentina.addTwoNeighbors(Peru, Brazil);
		
		//Add neighbors for Europe 
		Iceland.addThreeNeighbors(Greenland, GreatBritain, Scandinavia);
		GreatBritain.addFourNeighbors(Iceland, Scandinavia, WesternEurope, NorthernEurope);
		WesternEurope.addFourNeighbors(NorthAfrica, GreatBritain, NorthernEurope, SouthernEurope);
		NorthernEurope.addFiveNeighbors(GreatBritain, Scandinavia, SouthernEurope, WesternEurope, Ukraine);
		Scandinavia.addFourNeighbors(Iceland, GreatBritain, NorthernEurope, Ukraine);
		SouthernEurope.addSixNeighbors(WesternEurope, NorthernEurope, Egypt, MiddleEast, Ukraine, NorthAfrica);
		Ukraine.addSixNeighbors(SouthernEurope, MiddleEast, NorthernEurope, Scandinavia, Ural, Afghanistan);
		
		//Add neighbors for Africa
		
		//Add neighbors for Asia
		
		//Add neighbors for Australia
		return;
	}
}