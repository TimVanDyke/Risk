package classes;

import java.net.URL;
import java.util.ResourceBundle;

import org.hamcrest.SelfDescribing;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

public class Controller implements Initializable {	
	
	/** the board */
	private Board board;
	
	private int numUnitsAvailable;
	
	/** the text for the current player, country, numUnits*/
	public Text currentPlayerLabel;
	public Text currentCountryLabel;
	public Text numUnitsAvailableLabel;
	public Text attRollLabel;
	public Text defRollLabel;
	
	/** the text for the numUnits on each Country 
	 These have to stay public in order for 
	 View to be able to use them*/
	public Text alaskaLabel;
	public Text northWestTerritoryLabel;
	public Text albertaLabel;
	public Text ontarioLabel;
	public Text quebecLabel;
	public Text greenlandLabel;
	public Text easternUSLabel;
	public Text westernUSLabel;
	public Text centralAmericaLabel;
	public Text venezuelaLabel;
	public Text peruLabel;
	public Text argentinaLabel;
	public Text brazilLabel;
	public Text icelandLabel;
	public Text greatBritainLabel;
	public Text scandinaviaLabel;
	public Text westernEuropeLabel;
	public Text northernEuropeLabel;
	public Text southernEuropeLabel;
	public Text ukraineLabel;
	public Text egyptLabel;
	public Text northAfricaLabel;
	public Text congoLabel;
	public Text eastAfricaLabel;
	public Text southAfricaLabel;
	public Text madagascarLabel;
	public Text middleEastLabel;
	public Text afghanistanLabel;
	public Text uralLabel;
	public Text siberiaLabel;
	public Text yakutskLabel;
	public Text kamchatkaLabel;
	public Text irkutskLabel;
	public Text mongoliaLabel;
	public Text chinaLabel;
	public Text indiaLabel;
	public Text siamLabel;
	public Text japanLabel;
	public Text indonesiaLabel;
	public Text newGuineaLabel;
	public Text westernAustraliaLabel;
	public Text easternAustraliaLabel;
	
//	/** the screen */
//	private Screen screen;
	
	/** The world */
	private Country[] world;
	
	/** player 1. */
	private Player p1;
	
	/** player 2. */
	private Player p2;
	
	/** the player whose turn it is. */
	private Player turn;
	
	/** which country is highlighted. */
	private Country selected;
	
	/** whether or not a country is selected. */
	private boolean showMenu;
	
	/** the attackers choice. */
	private int choice;
	
	/** the attackers choice. */
	private Die attDie;
	
	/** the attackers choice. */
	private Die defDie;
	
	/** Countries. */
	private Country Alaska, NorthwestTerritory, Greenland, Alberta, Ontario,
	Quebec, EasternUS, WesternUS, CentralAmerica, Venezuela, Peru, Argentina,
	Brazil, Iceland, GreatBritain, NorthernEurope, Scandinavia, WesternEurope,
	SouthernEurope, Ukraine, NorthAfrica, Egypt, EastAfrica, Congo, SouthAfrica,
	Madagascar, MiddleEast, Afghanistan, Ural, Siberia, Yakutsk, Irkutsk,
	Japan, Mongolia, China, India, Kamchatka, Siam, Indonesia, NewGuinea,
	WesternAustralia, EasternAustralia;
	
	/** choicebox (dropdown) for attack and addunits) */
	public ChoiceBox<String> decision;
//	/****************************************************************************
//	 * The constructor for controller. This is called by view.
//	 * @param s1 : A name for player 1
//	 * @param s2 : a name for player 2
//	 ***************************************************************************/
//	public Controller(final String s1, final String s2) {
//		//makes a screen 
//		board = new Board();
//		
//		p1 = new Player(s1);
//		p2 = new Player(s2);
//		
//		attDie = new Die();
//		defDie = new Die();
//		
//		turn = p1;
//		
//		initializeCountries();
//		
//	}
//	
//	/****************************************************************************
//	 * The constructor for controller. This is called by view.
//	 * @param s1 : a name for player 1
//	 ***************************************************************************/
//	public Controller(final String s1) {
//		//makes a screen 
//		board = new Board();
//		
//		p1 = new Player(s1);
//		p2 = new Player("Risk Bot");
//	
//		attDie = new Die();
//		defDie = new Die();
//		
//		turn = p1;
//		
//		initializeCountries();
//	}
//	
//	/****************************************************************************
//	 * The constructor for controller. This is called by view.
//	 ***************************************************************************/
//	public Controller() {
//		//makes a screen 
//		board = new Board();
//		
//		p1 = new Player("Hi");
//		p2 = new Player("Risk Bot");
//	
//		attDie = new Die();
//		defDie = new Die();
//		
//		turn = p1;
//		
//		initializeCountries();
//	}
	
	/****************************************************************************
	 * The constructor for controller. This is called by view.
	 * @param s1 : a name for player 1
	 ***************************************************************************/
	public Controller() {
		//makes a screen 
		board = new Board();
		
		p1 = new Player("P1");
		p2 = new Player("P2");
		
		attDie = new Die();
		defDie = new Die();
		
		numUnitsAvailable = 3;
		numUnitsAvailableLabel = new Text(Integer.toString(numUnitsAvailable));
		turn = p1;
		turn.setKingdom(p1.getKingdom());
		//FIXME remove this
//		turn.addCountry(Alaska);
//		if (turn.isOwned(Alaska))
//			System.out.println("Turn does own Alaska");
//		
//		if (turn.getName().equals(p1.getName()))
//			System.out.println("It is P1's Turn");
		p1.setKingdom(turn.getKingdom());
		
		decision = new ChoiceBox<>();
		
		world = new Country[42];
		initializeCountries();
		

		currentPlayerLabel = new Text("");
		currentCountryLabel = new Text("");
		alaskaLabel = new Text("");
		northWestTerritoryLabel = new Text("");
		albertaLabel = new Text("");
		ontarioLabel = new Text("");
		quebecLabel = new Text("");
		greenlandLabel = new Text("");
		easternUSLabel = new Text("");
		westernUSLabel = new Text("");
		centralAmericaLabel = new Text("");
		venezuelaLabel = new Text("");
		peruLabel = new Text("");
		argentinaLabel = new Text("");
		brazilLabel = new Text("");
		icelandLabel = new Text("");
		greatBritainLabel = new Text("");
		scandinaviaLabel = new Text("");
		westernEuropeLabel = new Text("");
		northernEuropeLabel = new Text("");
		southernEuropeLabel = new Text("");
		ukraineLabel = new Text("");
		egyptLabel = new Text("");
		northAfricaLabel = new Text("");
		congoLabel = new Text("");
		eastAfricaLabel = new Text("");
		southAfricaLabel = new Text("");
		madagascarLabel = new Text("");
		middleEastLabel = new Text("");
		afghanistanLabel = new Text("");
		uralLabel = new Text("");
		siberiaLabel = new Text("");
		yakutskLabel = new Text("");
		kamchatkaLabel = new Text("");
		irkutskLabel = new Text("");
		mongoliaLabel = new Text("");
		chinaLabel = new Text("");
		indiaLabel = new Text("");
		siamLabel = new Text("");
		japanLabel = new Text("");
		indonesiaLabel = new Text("");
		newGuineaLabel = new Text("");
		westernAustraliaLabel = new Text("");
		easternAustraliaLabel = new Text("");
		
		attRollLabel = new Text("");
		defRollLabel = new Text("");
		
		p1.addCountry(Alaska);
		Alaska.setNumUnits(5);
		Alaska.setOwner(p1);
		
		p2.addCountry(NorthwestTerritory);
		NorthwestTerritory.setNumUnits(5);
		NorthwestTerritory.setOwner(p2);
		
		p1.addCountry(Greenland);
		Greenland.setNumUnits(5);
		Greenland.setOwner(p1);
		
		p2.addCountry(Alberta);
		Alberta.setNumUnits(5);
		Alberta.setOwner(p2);
		
		p1.addCountry(Ontario);
		Ontario.setNumUnits(5);
		Ontario.setOwner(p1);
		
		p2.addCountry(Quebec);
		Quebec.setNumUnits(5);
		Quebec.setOwner(p2);
		
		p1.addCountry(EasternUS);
		EasternUS.setNumUnits(5);
		EasternUS.setOwner(p1);
		
		p2.addCountry(WesternUS);
		WesternUS.setNumUnits(5);
		WesternUS.setOwner(p2);
		
		p1.addCountry(CentralAmerica);
		CentralAmerica.setNumUnits(5);
		CentralAmerica.setOwner(p1);
		
		p2.addCountry(Venezuela);
		Venezuela.setNumUnits(5);
		Venezuela.setOwner(p2);
		
		p1.addCountry(Peru);
		Peru.setNumUnits(5);
		Peru.setOwner(p1);
		
		p2.addCountry(Argentina);
		Argentina.setNumUnits(5);
		Argentina.setOwner(p2);
		
		p1.addCountry(Brazil);
		Brazil.setNumUnits(5);
		Brazil.setOwner(p1);
		
		p2.addCountry(Quebec);
		Quebec.setNumUnits(5);
		Quebec.setOwner(p2);
		
		p1.addCountry(Iceland);
		Iceland.setNumUnits(5);
		Iceland.setOwner(p1);
		
		p2.addCountry(GreatBritain);
		GreatBritain.setNumUnits(5);
		GreatBritain.setOwner(p2);
		
		p1.addCountry(NorthernEurope);
		NorthernEurope.setNumUnits(5);
		NorthernEurope.setOwner(p1);
		
		p2.addCountry(Scandinavia);
		Scandinavia.setNumUnits(5);
		Scandinavia.setOwner(p2);
		
		p1.addCountry(WesternEurope);
		WesternEurope.setNumUnits(5);
		WesternEurope.setOwner(p1);
		
		p2.addCountry(SouthernEurope);
		SouthernEurope.setNumUnits(5);
		SouthernEurope.setOwner(p2);
		
		p1.addCountry(Ukraine);
		Ukraine.setNumUnits(5);
		Ukraine.setOwner(p1);
		
		p2.addCountry(NorthAfrica);
		NorthAfrica.setNumUnits(5);
		NorthAfrica.setOwner(p2);
		
		p1.addCountry(Egypt);
		Egypt.setNumUnits(5);
		Egypt.setOwner(p1);
		
		p2.addCountry(EastAfrica);
		EastAfrica.setNumUnits(5);
		EastAfrica.setOwner(p2);
		
		p1.addCountry(Congo);
		Congo.setNumUnits(5);
		Congo.setOwner(p1);
		
		p2.addCountry(SouthAfrica);
		SouthAfrica.setNumUnits(5);
		SouthAfrica.setOwner(p2);
		
		p1.addCountry(Madagascar);
		Madagascar.setNumUnits(5);
		Madagascar.setOwner(p1);
		
		p2.addCountry(MiddleEast);
		MiddleEast.setNumUnits(5);
		MiddleEast.setOwner(p2);
		
		p1.addCountry(Afghanistan);
		Afghanistan.setNumUnits(5);
		Afghanistan.setOwner(p1);
		
		p2.addCountry(Ural);
		Ural.setNumUnits(5);
		Ural.setOwner(p2);
		
		p1.addCountry(Siberia);
		Yakutsk.setNumUnits(5);
		Yakutsk.setOwner(p1);
		
		p2.addCountry(Irkutsk);
		Irkutsk.setNumUnits(5);
		Irkutsk.setOwner(p2);
		
		p1.addCountry(Japan);
		Japan.setNumUnits(5);
		Japan.setOwner(p1);
		
		p2.addCountry(Mongolia);
		Mongolia.setNumUnits(5);
		Mongolia.setOwner(p2);
		
		p1.addCountry(China);
		China.setNumUnits(5);
		China.setOwner(p1);
		
		
		p2.addCountry(India);
		India.setNumUnits(5);
		India.setOwner(p2);
		
		p1.addCountry(Kamchatka);
		Kamchatka.setNumUnits(5);
		Kamchatka.setOwner(p1);
		
		p2.addCountry(Siam);
		Siam.setNumUnits(5);
		Siam.setOwner(p2);
		
		p1.addCountry(Indonesia);
		Indonesia.setNumUnits(5);
		Indonesia.setOwner(p1);
		
		p2.addCountry(NewGuinea);
		NewGuinea.setNumUnits(5);
		NewGuinea.setOwner(p2);
		
		p1.addCountry(WesternAustralia);
		WesternAustralia.setNumUnits(5);
		WesternAustralia.setOwner(p1);
		
		p2.addCountry(EasternAustralia);
		EasternAustralia.setNumUnits(5);
		EasternAustralia.setOwner(p2);
		
	}
	
	/****************************************************************************
	 * @return the current turn as a player.
	 ***************************************************************************/
	public Player getTurn() {
		return turn;
	}
	
	/****************************************************************************
	 * Switches the turn from one player to the other.
	 ***************************************************************************/
	public void switchTurn() {
		if (turn == p1) {
			turn = p2;
		} else if (turn == p2) {
			turn = p1;
		}
	}
	
//	/****************************************************************************
//	 * Returns the array of all the countries
//	 * @return the world Country[].
//	 ***************************************************************************/
//	public Country[] getWorld() {
//		return world;
//	}
	
	/****************************************************************************
	 * @return the current selected country.
	 ***************************************************************************/
	public Country getSelected() {
		return selected;
	}

	/***************************************************************************
	 * Sets the selected country.
	 * @param selected : the selected country
	 ***************************************************************************/
	public void setSelected(final Country selected) {
		this.selected = selected;
	}

	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void alaskaClicked() {
		if (turn.isOwned(Alaska)) {
		this.selected = Alaska;
//		if (p1.isOwned(Alaska))
//			System.out.println("He does own Alaska");
		
//		if (turn.getName().equals(p1.getName()))
//			System.out.println("It is P1's Turn");
		updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void northWestTerritoryClicked() {
		System.out.println("North West Territy clicked");
		if (turn.kingdom.contains(NorthwestTerritory)) {
			this.selected = NorthwestTerritory;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void albertaClicked() {
		System.out.println("Alberta clicked");
		if (turn.kingdom.contains(Alberta)) {
			this.selected = Alberta;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void greenlandClicked() {
		System.out.println("Greenland clicked");
		if (turn.kingdom.contains(Greenland)) {
			this.selected = Greenland;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void ontarioClicked() {
		System.out.println("Ontario clicked");
		if (turn.kingdom.contains(Ontario)) {
			this.selected = Ontario;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void quebecClicked() {
		System.out.println("Quebec clicked");
		if (turn.kingdom.contains(Quebec)) {
			this.selected = Quebec;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void westernUnitedStatesClicked() {
		System.out.println("Western United States clicked");
		if (turn.kingdom.contains(WesternUS)) {
			this.selected = WesternUS;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void easternUnitedStatesClicked() {
		System.out.println("Eastern United States clicked");
		if (turn.kingdom.contains(EasternUS)) {
			this.selected = EasternUS;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void centralAmericaClicked() {
		System.out.println("Central America clicked");
		if (turn.kingdom.contains(CentralAmerica)) {
			this.selected = CentralAmerica;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void venezuelaClicked() {
		System.out.println("Venezuela clicked");
		if (turn.kingdom.contains(Venezuela)) {
			this.selected = Venezuela;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void peruClicked() {
		System.out.println("Peru clicked");
		if (turn.kingdom.contains(Peru)) {
			this.selected = Peru;
			updateDecision();
		}
	}
	
	public void argentinaClicked() {
		System.out.println("Argentina clicked");
		if (turn.kingdom.contains(Argentina)) {
			this.selected = Argentina;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void brazilClicked() {
		System.out.println("Brazil clicked");
		if (turn.kingdom.contains(Brazil)) {
			this.selected = Brazil;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void icelandClicked() {
		System.out.println("Iceland clicked");
		if (turn.kingdom.contains(Iceland)) {
			this.selected = Iceland;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void greatBritainClicked() {
		System.out.println("Great Britain clicked");
		if (turn.kingdom.contains(GreatBritain)) {
			this.selected = GreatBritain;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void scandinaviaClicked() {
		System.out.println("Scandinavia clicked");
		if (turn.kingdom.contains(Scandinavia)) {
			this.selected = Scandinavia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void westernEuropeClicked() {
		System.out.println("Western Europe clicked");
		if (turn.kingdom.contains(WesternEurope)) {
			this.selected = WesternEurope;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void northernEuropeClicked() {
		System.out.println("Northern Europeclicked");
		if (turn.kingdom.contains(NorthernEurope)) {
			this.selected = NorthernEurope;
			updateDecision();
		}
	}
	
	public void southernEuropeClicked() {
		System.out.println("Southern Europeclicked");
		if (turn.kingdom.contains(SouthernEurope)) {
			this.selected = SouthernEurope;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void ukraineClicked() {
		System.out.println("Ukraine clicked");
		if (turn.kingdom.contains(Ukraine)) {
			this.selected = Ukraine;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void northAfricaClicked() {
		System.out.println("North Africa clicked");
		if (turn.kingdom.contains(NorthAfrica)) {
			this.selected = NorthAfrica;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void egyptClicked() {
		System.out.println("Egypt clicked");
		if (turn.kingdom.contains(Egypt)) {
			this.selected = Egypt;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void congoClicked() {
		System.out.println("Congo clicked");
		if (turn.kingdom.contains(Congo)) {
			this.selected = Congo;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void eastAfricaClicked() {
		System.out.println("East Africa clicked");
		if (turn.kingdom.contains(EastAfrica)) {
			this.selected = EastAfrica;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void southAfricaClicked() {
		System.out.println("South Africa clicked");
		if (turn.kingdom.contains(SouthAfrica)) {
			this.selected = SouthAfrica;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void madagascarClicked() {
		System.out.println("Madagascar clicked");
		if (turn.kingdom.contains(Madagascar)) {
			this.selected = Madagascar;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void middleEastClicked() {
		System.out.println("Middle East clicked");
		if (turn.kingdom.contains(MiddleEast)) {
			this.selected = MiddleEast;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void afghanistanClicked() {
		System.out.println("Afghanistan clicked");
		if (turn.kingdom.contains(Afghanistan)) {
			this.selected = Afghanistan;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void uralClicked() {
		System.out.println("Ural clicked");
		if (turn.kingdom.contains(Ural)) {
			this.selected = Ural;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void siberiaClicked() {
		System.out.println("Siberia clicked");
		if (turn.kingdom.contains(Siberia)) {
			this.selected = Siberia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void yakutskClicked() {
		System.out.println("Yakutsk clicked");
		if (turn.kingdom.contains(Yakutsk)) {
			this.selected = Yakutsk;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void kamchatkaClicked() {
		System.out.println("Kamchatka clicked");
		if (turn.kingdom.contains(Kamchatka)) {
			this.selected = Kamchatka;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void irkutskClicked() {
		System.out.println("Irkutsk clicked");
		if (turn.kingdom.contains(Irkutsk)) {
			this.selected = Irkutsk;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void mongoliaClicked() {
		System.out.println("Mongolia clicked");
		if (turn.kingdom.contains(Mongolia)) {
			this.selected = Mongolia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void chinaClicked() {
		System.out.println("China clicked");
		if (turn.kingdom.contains(China)) {
			this.selected = China;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void indiaClicked() {
		System.out.println("India clicked");
		if (turn.kingdom.contains(India)) {
			this.selected = India;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void siamClicked() {
		System.out.println("Siam clicked");
		if (turn.kingdom.contains(Siam)) {
			this.selected = Siam;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void japanClicked() {
		System.out.println("Japan clicked");
		if (turn.kingdom.contains(Japan)) {
			this.selected = Japan;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void indonesiaClicked() {
		System.out.println("Indonesia clicked");
		if (turn.kingdom.contains(Indonesia)) {
			this.selected = Indonesia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void westernAustraliaClicked() {
		System.out.println("Western Australia clicked");
		if (turn.kingdom.contains(WesternAustralia)) {
			this.selected = WesternAustralia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void newGuineaClicked() {
		System.out.println("New Guinea clicked");
		if (turn.kingdom.contains(NewGuinea)) {
			this.selected = NewGuinea;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void easternAustraliaClicked() {
		System.out.println("Eastern Australia clicked");
		if (turn.kingdom.contains(EasternAustralia)) {
			this.selected = EasternAustralia;
			updateDecision();
		}
	}
	
	/****************************************************************************
	 * Initializes all countries, and adds neighbors for each country.
	 ***************************************************************************/
	private void initializeCountries() {
		Alaska = new Country("Alaska", 3);
		NorthwestTerritory = new Country("Northwest Territory", 4);
		Greenland = new Country("Greenland", 4);
		Alberta = new Country("Alberta", 4);
		Ontario = new Country("Ontario", 6);
		Quebec = new Country("Quebec", 3);
		EasternUS = new Country("Eastern United States", 4);
		WesternUS = new Country("Western United States", 4);
		CentralAmerica = new Country("Central America", 3);
		
		//South America
		Venezuela = new Country("Venezuela", 3);
		Peru = new Country("Peru", 3);
		Argentina = new Country("Argentina", 2);
		Brazil = new Country("Brazil", 4);
		
		//Europe
		Iceland = new Country("Iceland", 3);
		GreatBritain = new Country("Great Britain", 4);
		NorthernEurope = new Country("Northern Europe", 5);
		Scandinavia = new Country("Scandinavia", 4);
		WesternEurope = new Country("Western Europe", 4);
	    SouthernEurope = new Country("Southern Europe", 6);
		Ukraine = new Country("Ukraine", 6);
		
		//Africa
		NorthAfrica = new Country("North Africa", 6);
		Egypt = new Country("Egypt", 4);
		EastAfrica = new Country("East Africa", 6);
		Congo = new Country("Congo", 3);
		SouthAfrica = new Country("South Africa", 3);
		Madagascar = new Country("Madagascar", 2);
		
		//Asia
		MiddleEast = new Country("Middle East", 6);
		Afghanistan = new Country("Afghanistan", 5);
		Ural = new Country("Ural", 4);
		Siberia = new Country("Siberia", 5);
		Yakutsk = new Country("Yakutsk", 3);
		Irkutsk = new Country("Irkutsk", 4);
		Japan = new Country("Japan", 2);
		Mongolia = new Country("Mongolia", 5);
		China = new Country("China", 6);
		India = new Country("India", 4);
		Kamchatka = new Country("Kamchatka", 5);
		Siam = new Country("Siam", 3);
		
		//Australia
		Indonesia = new Country("Indonesia", 3);
		NewGuinea = new Country("New Guinea", 3);
		WesternAustralia = new Country("Western Australia", 3);
		EasternAustralia = new Country("Eastern Australia", 2);
		
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
		
		world[0] = Alaska;
		world[1] = NorthwestTerritory;
		world[2] = Greenland;
		world[3] = Alberta;
		world[4] = Ontario;
		world[5] = Quebec;
		world[6] = EasternUS;
		world[7] = WesternUS;
		world[8] = CentralAmerica;
		world[9] = Venezuela;
		world[10] = Peru;
		world[11] = Argentina;
		world[12] = Brazil;
		world[13] = Iceland;
		world[14] = GreatBritain;
		world[15] = NorthernEurope;
		world[16] = Scandinavia;
		world[17] = WesternEurope;
		world[18] = SouthernEurope;
		world[19] = Ukraine;
		world[20] = NorthAfrica;
		world[21] = Egypt;
		world[22] = EastAfrica;
		world[23] = Congo;
		world[24] = SouthAfrica;
		world[25] = Madagascar;
		world[26] = MiddleEast;
		world[27] = Afghanistan;
		world[28] = Ural;
		world[29] = Siberia;
		world[30] = Yakutsk;
		world[31] = Irkutsk;
		world[32] = Japan;
		world[33] = Mongolia;
		world[34] = China;
		world[35] = India;
		world[36] = Kamchatka;
		world[37] = Siam;
		world[38] = Indonesia;
		world[39] = NewGuinea;
		world[40] = WesternAustralia;
		world[41] = EasternAustralia;
		
		return;
	}
	
	/****************************************************************************
	 * Takes action when add units is clicked.
	 ***************************************************************************/
	public void addUnitsButton() {
		if (turn.isOwned(selected)) {
			selected.setNumUnits("add", numUnitsAvailable);
			numUnitsAvailable = 0;
		}
		updateText();
	}
	
	/****************************************************************************
	 * When attacked is clicked.
	 ***************************************************************************/
	public void attackButton() {
		System.out.println("you clicked attack");
		//if (turn.isOwned(decision.getValue())) {
		///}
		int attRoll = attDie.roll();
		int defRoll = defDie.roll();
		attRollLabel.setText(Integer.toString(attRoll));
		defRollLabel.setText(Integer.toString(defRoll));
		System.out.println("attRoll: " + attRoll);
		System.out.println("defRoll: " + defRoll);
		Country defender;
		for (int i = 0; i < world.length; i++){
			if (decision.getSelectionModel().getSelectedItem().equals((world[i]).getName())) {
				defender = world[i];
				board.attack(selected, defender, attRoll, defRoll);
			}
		}
		//decision.getSelectionModel().getSelectedItem().
		
		updateText();
	}
	
	/****************************************************************************
	 * When the end turn button is clicked.
	 ***************************************************************************/
	public void endTurnButton() {
		System.out.println("You clicked end turn");
		if (turn == p1) {
			turn = p2;
			numUnitsAvailable = p2.selectNumUnits();
		} else {
			turn = p1;
			numUnitsAvailable = p1.selectNumUnits();
		}
		updateText();
	}
	
	/****************************************************************************
	 * Updates the selection box.
	 ***************************************************************************/
	private void updateDecision() {
		for (int i = 0; i < decision.getItems().size(); i++) {
			decision.getItems().remove(i);
		}
		decision.getItems().add(selected.getName());
		for (int i = 0; i < selected.getNeighbors().length; i++) {
			decision.getItems().add(selected.getNeighbors()[i].getName());
		}
		decision.setValue(selected.getName());
		updateText();
	}
	
	/****************************************************************************
	 * Updates the text labels.
	 ***************************************************************************/
	private void updateText() {
		//updating currentPlayer
		currentPlayerLabel.setText(turn.getName());
		//updating currentCountry
		if (selected != null) {
			currentCountryLabel.setText(selected.getName());
		}
		//updating numUnitsLeft
		numUnitsAvailableLabel.setText(Integer.toString(numUnitsAvailable));
		//updating country's numUnit display
		alaskaLabel.setText(Integer.toString(Alaska.getNumUnits()));
		northWestTerritoryLabel.setText(Integer.toString(NorthwestTerritory.getNumUnits()));
		albertaLabel.setText(Integer.toString(Alberta.getNumUnits()));
		ontarioLabel.setText(Integer.toString(Ontario.getNumUnits()));
		quebecLabel.setText(Integer.toString(Quebec.getNumUnits()));
		greenlandLabel.setText(Integer.toString(Greenland.getNumUnits()));
		easternUSLabel.setText(Integer.toString(EasternUS.getNumUnits()));
		westernUSLabel.setText(Integer.toString(WesternUS.getNumUnits()));
		centralAmericaLabel.setText(Integer.toString(CentralAmerica.getNumUnits()));
		venezuelaLabel.setText(Integer.toString(Venezuela.getNumUnits()));
		peruLabel.setText(Integer.toString(Peru.getNumUnits()));
		argentinaLabel.setText(Integer.toString(Argentina.getNumUnits()));
		brazilLabel.setText(Integer.toString(Brazil.getNumUnits()));
		icelandLabel.setText(Integer.toString(Iceland.getNumUnits()));
		greatBritainLabel.setText(Integer.toString(GreatBritain.getNumUnits()));
		scandinaviaLabel.setText(Integer.toString(Scandinavia.getNumUnits()));
		westernEuropeLabel.setText(Integer.toString(WesternEurope.getNumUnits()));
		northernEuropeLabel.setText(Integer.toString(NorthernEurope.getNumUnits()));
		southernEuropeLabel.setText(Integer.toString(SouthernEurope.getNumUnits()));
		ukraineLabel.setText(Integer.toString(Ukraine.getNumUnits()));
		egyptLabel.setText(Integer.toString(Egypt.getNumUnits()));
		northAfricaLabel.setText(Integer.toString(NorthAfrica.getNumUnits()));
		congoLabel.setText(Integer.toString(Congo.getNumUnits()));
		eastAfricaLabel.setText(Integer.toString(EastAfrica.getNumUnits()));
		southAfricaLabel.setText(Integer.toString(SouthAfrica.getNumUnits()));
		madagascarLabel.setText(Integer.toString(Madagascar.getNumUnits()));
		middleEastLabel.setText(Integer.toString(MiddleEast.getNumUnits()));
		afghanistanLabel.setText(Integer.toString(Afghanistan.getNumUnits()));
		uralLabel.setText(Integer.toString(Ural.getNumUnits()));
		siberiaLabel.setText(Integer.toString(Siberia.getNumUnits()));
		yakutskLabel.setText(Integer.toString(Yakutsk.getNumUnits()));
		kamchatkaLabel.setText(Integer.toString(Kamchatka.getNumUnits()));
		irkutskLabel.setText(Integer.toString(Irkutsk.getNumUnits()));
		mongoliaLabel.setText(Integer.toString(Mongolia.getNumUnits()));
		chinaLabel.setText(Integer.toString(China.getNumUnits()));
		indiaLabel.setText(Integer.toString(India.getNumUnits()));
		siamLabel.setText(Integer.toString(Siam.getNumUnits()));
		japanLabel.setText(Integer.toString(Japan.getNumUnits()));
		indonesiaLabel.setText(Integer.toString(Indonesia.getNumUnits()));
		newGuineaLabel.setText(Integer.toString(NewGuinea.getNumUnits()));
		westernAustraliaLabel.setText(Integer.toString(WesternAustralia.getNumUnits()));
		easternAustraliaLabel.setText(Integer.toString(EasternAustralia.getNumUnits()));
		
	}

	@Override
	/****************************************************************************
	 * Updates the text labels.
	 ***************************************************************************/
	public void initialize(URL location, ResourceBundle resources) {
		updateText();
	}
}
