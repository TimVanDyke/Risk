package classes;

import java.awt.Component;

/****************************************************************************
 * A class to initialize everything, then had it all off to the GUI
 ***************************************************************************/
public class Main {
	
	/** the width of the screen */
	private int width;
	
	/** the height of the screen */
	private int height;
	
	/** the board */
	private Board board;
	
	/** the screen */
	private Screen screen;
	
	/** The world */
	private Country[] world;
	
	/** player 1 */
	private Player p1;
	
	/** player 2 */
	private Player p2;
	
	/** the player whose turn it is */
	private Player turn;
	
	/** which country is highlighted */
	private Country selected;
	
	/** whether or not a country is selected */
	private boolean select;
	
	/** creating green */
	Country green;
	
	/** creating magenta */
	Country magenta;
	
	/** creating purple */
	Country purple;
	
	/** creating yellow */
	Country yellow;
	
	/****************************************************************************
	 * The constructor for main. This is called by gui.
	 ***************************************************************************/
	public Main(int width, int height) {
		//makes a screen 
		screen = new Screen(width, height);
		board = new Board();
		
		testNeighbors();
		
		p1 = new Player("Matt");
		p2 = new Player("Tim");
		
		p1.addCountry(green);

		p2.addCountry(yellow);

		//adding all the countries to the world
		world = new Country[42];
		world[0] = green;
		world[1] = magenta;
		world[2] = purple;
		world[3] = yellow;

	}
	
	/****************************************************************************
	 * Initializes all countries, and adds neighbors for each country
	 ***************************************************************************/
	private void intializeCountries(){
		//North America
		String a = "hi";
		Country Alaska = new Country("Alaska", 3, a);
		Country NorthwestTerritory = new Country("Northwest Territory", 4, a);
		Country Greenland = new Country("Greenland", 4, a);
		Country Alberta = new Country("Alberta", 4, a);
		Country Ontario = new Country("Ontario", 6, a);
		Country Quebec = new Country("Quebec", 3, a);
		Country EasternUS = new Country("Eastern United States", 4, a);
		Country WesternUS = new Country("Western United States", 4, a);
		Country CentralAmerica = new Country("Central America", 3, a);
		
		//South America
		Country Venezuela = new Country("Venezuela", 3, a);
		Country Peru = new Country("Peru", 3, a);
		Country Argentina = new Country("Argentina", 2, a);
		Country Brazil = new Country("Brazil", 4, a);
		
		//Europe
		Country Iceland = new Country("Iceland", 3, a);
		Country GreatBritain = new Country("Great Britain", 4, a);
		Country NorthernEurope = new Country("Northern Europe", 5, a);
		Country Scandinavia = new Country("Scandinavia", 4, a);
		Country WesternEurope = new Country("Western Europe", 4, a);
		Country SouthernEurope = new Country("Southern Europe", 6, a);
		Country Ukraine = new Country("Ukraine", 6, a);
		
		//Africa
		Country NorthAfrica = new Country("North Africa", 6, a);
		Country Egypt = new Country("Egypt", 4, a);
		Country EastAfrica = new Country("East Africa", 6, a);
		Country Congo = new Country("Congo", 3, a);
		Country SouthAfrica = new Country("South Africa", 3, a);
		Country Madagascar = new Country("Madagascar", 2, a);
		
		//Asia
		Country MiddleEast = new Country("Middle East", 6, a);
		Country Afghanistan = new Country("Afghanistan", 5, a);
		Country Ural = new Country("Ural", 4, a);
		Country Siberia = new Country("Siberia", 5, a);
		Country Yakutsk = new Country("Yakutsk", 3, a);
		Country Irkutsk = new Country("Irkutsk", 4, a);
		Country Japan = new Country("Japan", 2, a);
		Country Mongolia = new Country("Mongolia", 5, a);
		Country China = new Country("China", 6, a);
		Country India = new Country("India", 4, a);
		Country Kamchatka = new Country("Kamchatka", 5, a);
		Country Siam = new Country("Siam", 3, a);
		
		//Australia
		Country Indonesia = new Country("Indonesia", 3, a);
		Country NewGuinea = new Country("New Guinea", 3, a);
		Country WesternAustralia = new Country("Western Australia", 3, a);
		Country EasternAustralia = new Country("Eastern Australia", 2, a);
		
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
		NorthAfrica.addSixNeighbors(Brazil, WesternEurope, SouthernEurope, Egypt, EastAfrica, Congo);
		Egypt.addFourNeighbors(NorthAfrica, SouthernEurope, MiddleEast, EastAfrica);
		EastAfrica.addSixNeighbors(Egypt, MiddleEast, Madagascar, SouthAfrica, Congo, NorthAfrica);
		Congo.addThreeNeighbors(NorthAfrica, EastAfrica, SouthAfrica);
		SouthAfrica.addThreeNeighbors(Congo, EastAfrica, Madagascar);
		Madagascar.addTwoNeighbors(EastAfrica, SouthAfrica);
		
		//Add neighbors for Asia
		MiddleEast.addSixNeighbors(Ukraine, Afghanistan, India, EastAfrica, Egypt, SouthernEurope);
		Afghanistan.addFiveNeighbors(Ural, China, India, MiddleEast, Ukraine);
		Ural.addFourNeighbors(Siberia, China, Afghanistan, Ukraine);
		Siberia.addFiveNeighbors(Yakutsk, Irkutsk, Mongolia, China, Ural);
		Yakutsk.addThreeNeighbors(Ural, Irkutsk, Kamchatka);
		Irkutsk.addFourNeighbors(Yakutsk, Kamchatka, Mongolia, Siberia);
		Japan.addTwoNeighbors(Kamchatka, Mongolia);
		Mongolia.addFiveNeighbors(Irkutsk, Kamchatka, Japan, China, Siberia);
		China.addSixNeighbors(Mongolia, Siam, India, Afghanistan, Ural, Siberia);
		India.addFourNeighbors(China, Siam, MiddleEast, Afghanistan);
		Kamchatka.addFiveNeighbors(Yakutsk, Alaska, Japan, Mongolia, Irkutsk);
		Siam.addThreeNeighbors(China, Indonesia, India);
		
		//Add neighbors for Australia
		Indonesia.addThreeNeighbors(Siam, NewGuinea, WesternAustralia);
		NewGuinea.addThreeNeighbors(Indonesia, WesternAustralia, EasternAustralia);
		WesternAustralia.addThreeNeighbors(Indonesia, NewGuinea, EasternAustralia);
		EasternAustralia.addTwoNeighbors(WesternAustralia, NewGuinea);
		
		return;
	}
	
	/****************************************************************************
	 * Initializes test countries, and adds neighbors for each country
	 * This method will be deleted later
	 ***************************************************************************/
	private void testNeighbors() {
		green = new Country("green", 3, "res/testCountryGreen");
		magenta = new Country("magenta", 3, "res/testCountryMagenta");
		purple = new Country("Purple", 3, "res/testCountry");
		yellow = new Country("yellow", 3, "res/testCountry");
		
		green.addThreeNeighbors(magenta, purple, yellow);
		magenta.addThreeNeighbors(green, purple, yellow);
		purple.addThreeNeighbors(green, magenta, yellow);
		yellow.addThreeNeighbors(green, magenta, purple);
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void render(int[] pixels) {
		// TODO Auto-generated method stub
		
	}

	public Component getTurn() {
		// TODO Auto-generated method stub
		return null;
	}
	
}