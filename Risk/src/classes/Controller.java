package classes;

import java.net.URL;
import java.util.ResourceBundle;

import org.hamcrest.SelfDescribing;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/****************************************************************************
 * Controller class.
 ***************************************************************************/
public class Controller implements Initializable {	
	
	/** the board. */
	private Board board;
	
	/** num units available. */
	private int numUnitsAvailable;
	
	/** the text for the current player, country, numUnits.*/
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
	
	/** The world. */
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
	
	/** choicebox (dropdown) for attack and addunits). */
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
		
		p2.addCountry(Siberia);
		Siberia.setNumUnits(5);
		Siberia.setOwner(p2);
		
		p1.addCountry(Yakutsk);
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
		updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void northWestTerritoryClicked() {
		if (turn.kingdom.contains(NorthwestTerritory)) {
			this.selected = NorthwestTerritory;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void albertaClicked() {
		if (turn.kingdom.contains(Alberta)) {
			this.selected = Alberta;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void greenlandClicked() {
		if (turn.kingdom.contains(Greenland)) {
			this.selected = Greenland;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void ontarioClicked() {
		if (turn.kingdom.contains(Ontario)) {
			this.selected = Ontario;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void quebecClicked() {
		if (turn.kingdom.contains(Quebec)) {
			this.selected = Quebec;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void westernUnitedStatesClicked() {
		if (turn.kingdom.contains(WesternUS)) {
			this.selected = WesternUS;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void easternUnitedStatesClicked() {
		if (turn.kingdom.contains(EasternUS)) {
			this.selected = EasternUS;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void centralAmericaClicked() {
		if (turn.kingdom.contains(CentralAmerica)) {
			this.selected = CentralAmerica;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void venezuelaClicked() {
		if (turn.kingdom.contains(Venezuela)) {
			this.selected = Venezuela;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void peruClicked() {
		if (turn.kingdom.contains(Peru)) {
			this.selected = Peru;
			updateDecision();
		}
	}
	
	public void argentinaClicked() {
		if (turn.kingdom.contains(Argentina)) {
			this.selected = Argentina;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void brazilClicked() {
		if (turn.kingdom.contains(Brazil)) {
			this.selected = Brazil;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void icelandClicked() {
		if (turn.kingdom.contains(Iceland)) {
			this.selected = Iceland;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void greatBritainClicked() {
		if (turn.kingdom.contains(GreatBritain)) {
			this.selected = GreatBritain;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void scandinaviaClicked() {
		if (turn.kingdom.contains(Scandinavia)) {
			this.selected = Scandinavia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void westernEuropeClicked() {
		if (turn.kingdom.contains(WesternEurope)) {
			this.selected = WesternEurope;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void northernEuropeClicked() {
		if (turn.kingdom.contains(NorthernEurope)) {
			this.selected = NorthernEurope;
			updateDecision();
		}
	}
	
	public void southernEuropeClicked() {
		if (turn.kingdom.contains(SouthernEurope)) {
			this.selected = SouthernEurope;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void ukraineClicked() {
		if (turn.kingdom.contains(Ukraine)) {
			this.selected = Ukraine;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void northAfricaClicked() {
		if (turn.kingdom.contains(NorthAfrica)) {
			this.selected = NorthAfrica;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void egyptClicked() {
		if (turn.kingdom.contains(Egypt)) {
			this.selected = Egypt;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void congoClicked() {
		if (turn.kingdom.contains(Congo)) {
			this.selected = Congo;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void eastAfricaClicked() {
		if (turn.kingdom.contains(EastAfrica)) {
			this.selected = EastAfrica;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void southAfricaClicked() {
		if (turn.kingdom.contains(SouthAfrica)) {
			this.selected = SouthAfrica;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void madagascarClicked() {
		if (turn.kingdom.contains(Madagascar)) {
			this.selected = Madagascar;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void middleEastClicked() {
		if (turn.kingdom.contains(MiddleEast)) {
			this.selected = MiddleEast;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void afghanistanClicked() {
		if (turn.kingdom.contains(Afghanistan)) {
			this.selected = Afghanistan;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void uralClicked() {
		if (turn.kingdom.contains(Ural)) {
			this.selected = Ural;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void siberiaClicked() {
		if (turn.kingdom.contains(Siberia)) {
			this.selected = Siberia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void yakutskClicked() {
		if (turn.kingdom.contains(Yakutsk)) {
			this.selected = Yakutsk;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void kamchatkaClicked() {
		if (turn.kingdom.contains(Kamchatka)) {
			this.selected = Kamchatka;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void irkutskClicked() {
		if (turn.kingdom.contains(Irkutsk)) {
			this.selected = Irkutsk;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void mongoliaClicked() {
		if (turn.kingdom.contains(Mongolia)) {
			this.selected = Mongolia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void chinaClicked() {
		if (turn.kingdom.contains(China)) {
			this.selected = China;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void indiaClicked() {
		if (turn.kingdom.contains(India)) {
			this.selected = India;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void siamClicked() {
		if (turn.kingdom.contains(Siam)) {
			this.selected = Siam;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void japanClicked() {
		if (turn.kingdom.contains(Japan)) {
			this.selected = Japan;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void indonesiaClicked() {
		if (turn.kingdom.contains(Indonesia)) {
			this.selected = Indonesia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void westernAustraliaClicked() {
		if (turn.kingdom.contains(WesternAustralia)) {
			this.selected = WesternAustralia;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void newGuineaClicked() {
		if (turn.kingdom.contains(NewGuinea)) {
			this.selected = NewGuinea;
			updateDecision();
		}
	}
	/****************************************************************************
	 * Selects this country when clicked.
	 ***************************************************************************/
	public void easternAustraliaClicked() {
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
		int attRoll = attDie.roll();
		int defRoll = defDie.roll();
		attRollLabel.setText(Integer.toString(attRoll));
		defRollLabel.setText(Integer.toString(defRoll));
		Country defender;
		for (int i = 0; i < world.length; i++){
			if (decision.getSelectionModel().getSelectedItem().equals((world[i]).getName())) {
				defender = world[i];
				board.attack(selected, defender, attRoll, defRoll);
			}
		}
		
		updateText();
	}
	
	/****************************************************************************
	 * When the end turn button is clicked.
	 ***************************************************************************/
	public void endTurnButton() {
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
		while (decision.getItems().size() > 0) {
			decision.getItems().remove(0);
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
		if(Alaska.getOwner().getName().equals(p1.getName())) {
			alaskaLabel.setFill(Color.BLUE);
		}
		else if (Alaska.getOwner().getName().equals(p2.getName())){
			alaskaLabel.setFill(Color.RED);
		}
		else {
			alaskaLabel.setFill(Color.BLACK);
		}
		northWestTerritoryLabel.setText(Integer.toString(NorthwestTerritory.getNumUnits()));
		if(NorthwestTerritory.getOwner().getName().equals(p1.getName())) {
			northWestTerritoryLabel.setFill(Color.BLUE);
		}
		else if (NorthwestTerritory.getOwner().getName().equals(p2.getName())){
			northWestTerritoryLabel.setFill(Color.RED);
		}
		else {
			northWestTerritoryLabel.setFill(Color.BLACK);
		}
		albertaLabel.setText(Integer.toString(Alberta.getNumUnits()));
		if(Alberta.getOwner().getName().equals(p1.getName())) {
			albertaLabel.setFill(Color.BLUE);
		}
		else if (Alberta.getOwner().getName().equals(p2.getName())){
			albertaLabel.setFill(Color.RED);
		}
		else {
			albertaLabel.setFill(Color.BLACK);
		}
		ontarioLabel.setText(Integer.toString(Ontario.getNumUnits()));
		if(Ontario.getOwner().getName().equals(p1.getName())) {
			ontarioLabel.setFill(Color.BLUE);
		}
		else if (Ontario.getOwner().getName().equals(p2.getName())){
			ontarioLabel.setFill(Color.RED);
		}
		else {
			ontarioLabel.setFill(Color.BLACK);
		}
		quebecLabel.setText(Integer.toString(Quebec.getNumUnits()));
		if(Quebec.getOwner().getName().equals(p1.getName())) {
			quebecLabel.setFill(Color.BLUE);
		}
		else if (Quebec.getOwner().getName().equals(p2.getName())){
			quebecLabel.setFill(Color.RED);
		}
		else {
			quebecLabel.setFill(Color.BLACK);
		}
		greenlandLabel.setText(Integer.toString(Greenland.getNumUnits()));
		if(Greenland.getOwner().getName().equals(p1.getName())) {
			greenlandLabel.setFill(Color.BLUE);
		}
		else if (Greenland.getOwner().getName().equals(p2.getName())){
			greenlandLabel.setFill(Color.RED);
		}
		else {
			greenlandLabel.setFill(Color.BLACK);
		}
		easternUSLabel.setText(Integer.toString(EasternUS.getNumUnits()));
		if(EasternUS.getOwner().getName().equals(p1.getName())) {
			easternUSLabel.setFill(Color.BLUE);
		}
		else if (EasternUS.getOwner().getName().equals(p2.getName())){
			easternUSLabel.setFill(Color.RED);
		}
		else {
			easternUSLabel.setFill(Color.BLACK);
		}
		westernUSLabel.setText(Integer.toString(WesternUS.getNumUnits()));
		if(WesternUS.getOwner().getName().equals(p1.getName())) {
			westernUSLabel.setFill(Color.BLUE);
		}
		else if (WesternUS.getOwner().getName().equals(p2.getName())){
			westernUSLabel.setFill(Color.RED);
		}
		else {
			westernUSLabel.setFill(Color.BLACK);
		}
		centralAmericaLabel.setText(Integer.toString(CentralAmerica.getNumUnits()));
		if(CentralAmerica.getOwner().getName().equals(p1.getName())) {
			centralAmericaLabel.setFill(Color.BLUE);
		}
		else if (CentralAmerica.getOwner().getName().equals(p2.getName())){
			centralAmericaLabel.setFill(Color.RED);
		}
		else {
			centralAmericaLabel.setFill(Color.BLACK);
		}
		venezuelaLabel.setText(Integer.toString(Venezuela.getNumUnits()));
		if(Venezuela.getOwner().getName().equals(p1.getName())) {
			venezuelaLabel.setFill(Color.BLUE);
		}
		else if (Venezuela.getOwner().getName().equals(p2.getName())){
			venezuelaLabel.setFill(Color.RED);
		}
		else {
			venezuelaLabel.setFill(Color.BLACK);
		}
		peruLabel.setText(Integer.toString(Peru.getNumUnits()));
		if(Peru.getOwner().getName().equals(p1.getName())) {
			peruLabel.setFill(Color.BLUE);
		}
		else if (Peru.getOwner().getName().equals(p2.getName())){
			peruLabel.setFill(Color.RED);
		}
		else {
			peruLabel.setFill(Color.BLACK);
		}
		argentinaLabel.setText(Integer.toString(Argentina.getNumUnits()));
		if(Argentina.getOwner().getName().equals(p1.getName())) {
			argentinaLabel.setFill(Color.BLUE);
		}
		else if (Argentina.getOwner().getName().equals(p2.getName())){
			argentinaLabel.setFill(Color.RED);
		}
		else {
			argentinaLabel.setFill(Color.BLACK);
		}
		brazilLabel.setText(Integer.toString(Brazil.getNumUnits()));
		if(Brazil.getOwner().getName().equals(p1.getName())) {
			brazilLabel.setFill(Color.BLUE);
		}
		else if (Brazil.getOwner().getName().equals(p2.getName())){
			brazilLabel.setFill(Color.RED);
		}
		else {
			brazilLabel.setFill(Color.BLACK);
		}
		icelandLabel.setText(Integer.toString(Iceland.getNumUnits()));
		if(Iceland.getOwner().getName().equals(p1.getName())) {
			icelandLabel.setFill(Color.BLUE);
		}
		else if (Iceland.getOwner().getName().equals(p2.getName())){
			icelandLabel.setFill(Color.RED);
		}
		else {
			icelandLabel.setFill(Color.BLACK);
		}
		greatBritainLabel.setText(Integer.toString(GreatBritain.getNumUnits()));
		if(GreatBritain.getOwner().getName().equals(p1.getName())) {
			greatBritainLabel.setFill(Color.BLUE);
		}
		else if (GreatBritain.getOwner().getName().equals(p2.getName())){
			greatBritainLabel.setFill(Color.RED);
		}
		else {
			greatBritainLabel.setFill(Color.BLACK);
		}
		scandinaviaLabel.setText(Integer.toString(Scandinavia.getNumUnits()));
		if(Scandinavia.getOwner().getName().equals(p1.getName())) {
			scandinaviaLabel.setFill(Color.BLUE);
		}
		else if (Scandinavia.getOwner().getName().equals(p2.getName())){
			scandinaviaLabel.setFill(Color.RED);
		}
		else {
			scandinaviaLabel.setFill(Color.BLACK);
		}
		westernEuropeLabel.setText(Integer.toString(WesternEurope.getNumUnits()));
		if(WesternEurope.getOwner().getName().equals(p1.getName())) {
			westernEuropeLabel.setFill(Color.BLUE);
		}
		else if (WesternEurope.getOwner().getName().equals(p2.getName())){
			westernEuropeLabel.setFill(Color.RED);
		}
		else {
			westernEuropeLabel.setFill(Color.BLACK);
		}
		northernEuropeLabel.setText(Integer.toString(NorthernEurope.getNumUnits()));
		if(NorthernEurope.getOwner().getName().equals(p1.getName())) {
			northernEuropeLabel.setFill(Color.BLUE);
		}
		else if (NorthernEurope.getOwner().getName().equals(p2.getName())){
			northernEuropeLabel.setFill(Color.RED);
		}
		else {
			northernEuropeLabel.setFill(Color.BLACK);
		}
		southernEuropeLabel.setText(Integer.toString(SouthernEurope.getNumUnits()));
		if(SouthernEurope.getOwner().getName().equals(p1.getName())) {
			southernEuropeLabel.setFill(Color.BLUE);
		}
		else if (SouthernEurope.getOwner().getName().equals(p2.getName())){
			southernEuropeLabel.setFill(Color.RED);
		}
		else {
			southernEuropeLabel.setFill(Color.BLACK);
		}
		ukraineLabel.setText(Integer.toString(Ukraine.getNumUnits()));
		if(Ukraine.getOwner().getName().equals(p1.getName())) {
			ukraineLabel.setFill(Color.BLUE);
		}
		else if (Ukraine.getOwner().getName().equals(p2.getName())){
			ukraineLabel.setFill(Color.RED);
		}
		else {
			ukraineLabel.setFill(Color.BLACK);
		}
		egyptLabel.setText(Integer.toString(Egypt.getNumUnits()));
		if(Egypt.getOwner().getName().equals(p1.getName())) {
			egyptLabel.setFill(Color.BLUE);
		}
		else if (Egypt.getOwner().getName().equals(p2.getName())){
			egyptLabel.setFill(Color.RED);
		}
		else {
			egyptLabel.setFill(Color.BLACK);
		}
		northAfricaLabel.setText(Integer.toString(NorthAfrica.getNumUnits()));
		if(NorthAfrica.getOwner().getName().equals(p1.getName())) {
			northAfricaLabel.setFill(Color.BLUE);
		}
		else if (NorthAfrica.getOwner().getName().equals(p2.getName())){
			northAfricaLabel.setFill(Color.RED);
		}
		else {
			northAfricaLabel.setFill(Color.BLACK);
		}
		congoLabel.setText(Integer.toString(Congo.getNumUnits()));
		if(Congo.getOwner().getName().equals(p1.getName())) {
			congoLabel.setFill(Color.BLUE);
		}
		else if (Congo.getOwner().getName().equals(p2.getName())){
			congoLabel.setFill(Color.RED);
		}
		else {
			congoLabel.setFill(Color.BLACK);
		}
		eastAfricaLabel.setText(Integer.toString(EastAfrica.getNumUnits()));
		if(EastAfrica.getOwner().getName().equals(p1.getName())) {
			eastAfricaLabel.setFill(Color.BLUE);
		}
		else if (EastAfrica.getOwner().getName().equals(p2.getName())){
			eastAfricaLabel.setFill(Color.RED);
		}
		else {
			eastAfricaLabel.setFill(Color.BLACK);
		}
		southAfricaLabel.setText(Integer.toString(SouthAfrica.getNumUnits()));
		if(SouthAfrica.getOwner().getName().equals(p1.getName())) {
			southAfricaLabel.setFill(Color.BLUE);
		}
		else if (SouthAfrica.getOwner().getName().equals(p2.getName())){
			southAfricaLabel.setFill(Color.RED);
		}
		else {
			southAfricaLabel.setFill(Color.BLACK);
		}
		madagascarLabel.setText(Integer.toString(Madagascar.getNumUnits()));
		if(Madagascar.getOwner().getName().equals(p1.getName())) {
			madagascarLabel.setFill(Color.BLUE);
		}
		else if (Madagascar.getOwner().getName().equals(p2.getName())){
			madagascarLabel.setFill(Color.RED);
		}
		else {
			madagascarLabel.setFill(Color.BLACK);
		}
		middleEastLabel.setText(Integer.toString(MiddleEast.getNumUnits()));
		if(MiddleEast.getOwner().getName().equals(p1.getName())) {
			middleEastLabel.setFill(Color.BLUE);
		}
		else if (MiddleEast.getOwner().getName().equals(p2.getName())){
			middleEastLabel.setFill(Color.RED);
		}
		else {
			middleEastLabel.setFill(Color.BLACK);
		}
		afghanistanLabel.setText(Integer.toString(Afghanistan.getNumUnits()));
		if(Afghanistan.getOwner().getName().equals(p1.getName())) {
			afghanistanLabel.setFill(Color.BLUE);
		}
		else if (Afghanistan.getOwner().getName().equals(p2.getName())){
			afghanistanLabel.setFill(Color.RED);
		}
		else {
			afghanistanLabel.setFill(Color.BLACK);
		}
		uralLabel.setText(Integer.toString(Ural.getNumUnits()));
		if(Ural.getOwner().getName().equals(p1.getName())) {
			uralLabel.setFill(Color.BLUE);
		}
		else if (Ural.getOwner().getName().equals(p2.getName())){
			uralLabel.setFill(Color.RED);
		}
		else {
			uralLabel.setFill(Color.BLACK);
		}
		siberiaLabel.setText(Integer.toString(Siberia.getNumUnits()));
		if(Siberia.getOwner().getName().equals(p1.getName())) {
			siberiaLabel.setFill(Color.BLUE);
		}
		else if (Siberia.getOwner().getName().equals(p2.getName())){
			siberiaLabel.setFill(Color.RED);
		}
		else {
			siberiaLabel.setFill(Color.BLACK);
		}
		yakutskLabel.setText(Integer.toString(Yakutsk.getNumUnits()));
		if(Yakutsk.getOwner().getName().equals(p1.getName())) {
			yakutskLabel.setFill(Color.BLUE);
		}
		else if (Yakutsk.getOwner().getName().equals(p2.getName())){
			yakutskLabel.setFill(Color.RED);
		}
		else {
			yakutskLabel.setFill(Color.BLACK);
		}
		kamchatkaLabel.setText(Integer.toString(Kamchatka.getNumUnits()));
		if(Kamchatka.getOwner().getName().equals(p1.getName())) {
			kamchatkaLabel.setFill(Color.BLUE);
		}
		else if (Kamchatka.getOwner().getName().equals(p2.getName())){
			kamchatkaLabel.setFill(Color.RED);
		}
		else {
			kamchatkaLabel.setFill(Color.BLACK);
		}
		irkutskLabel.setText(Integer.toString(Irkutsk.getNumUnits()));
		if(Irkutsk.getOwner().getName().equals(p1.getName())) {
			irkutskLabel.setFill(Color.BLUE);
		}
		else if (Irkutsk.getOwner().getName().equals(p2.getName())){
			irkutskLabel.setFill(Color.RED);
		}
		else {
			irkutskLabel.setFill(Color.BLACK);
		}
		mongoliaLabel.setText(Integer.toString(Mongolia.getNumUnits()));
		if(Mongolia.getOwner().getName().equals(p1.getName())) {
			mongoliaLabel.setFill(Color.BLUE);
		}
		else if (Mongolia.getOwner().getName().equals(p2.getName())){
			mongoliaLabel.setFill(Color.RED);
		}
		else {
			mongoliaLabel.setFill(Color.BLACK);
		}
		chinaLabel.setText(Integer.toString(China.getNumUnits()));
		if(China.getOwner().getName().equals(p1.getName())) {
			chinaLabel.setFill(Color.BLUE);
		}
		else if (China.getOwner().getName().equals(p2.getName())){
			chinaLabel.setFill(Color.RED);
		}
		else {
			chinaLabel.setFill(Color.BLACK);
		}
		indiaLabel.setText(Integer.toString(India.getNumUnits()));
		if(India.getOwner().getName().equals(p1.getName())) {
			indiaLabel.setFill(Color.BLUE);
		}
		else if (India.getOwner().getName().equals(p2.getName())){
			indiaLabel.setFill(Color.RED);
		}
		else {
			indiaLabel.setFill(Color.BLACK);
		}
		siamLabel.setText(Integer.toString(Siam.getNumUnits()));
		if(Siam.getOwner().getName().equals(p1.getName())) {
			siamLabel.setFill(Color.BLUE);
		}
		else if (Siam.getOwner().getName().equals(p2.getName())){
			siamLabel.setFill(Color.RED);
		}
		else {
			siamLabel.setFill(Color.BLACK);
		}
		japanLabel.setText(Integer.toString(Japan.getNumUnits()));
		if(Japan.getOwner().getName().equals(p1.getName())) {
			japanLabel.setFill(Color.BLUE);
		}
		else if (Japan.getOwner().getName().equals(p2.getName())){
			japanLabel.setFill(Color.RED);
		}
		else {
			japanLabel.setFill(Color.BLACK);
		}
		indonesiaLabel.setText(Integer.toString(Indonesia.getNumUnits()));
		if(Indonesia.getOwner().getName().equals(p1.getName())) {
			indonesiaLabel.setFill(Color.BLUE);
		}
		else if (Indonesia.getOwner().getName().equals(p2.getName())){
			indonesiaLabel.setFill(Color.RED);
		}
		else {
			indonesiaLabel.setFill(Color.BLACK);
		}
		newGuineaLabel.setText(Integer.toString(NewGuinea.getNumUnits()));
		if(NewGuinea.getOwner().getName().equals(p1.getName())) {
			newGuineaLabel.setFill(Color.BLUE);
		}
		else if (NewGuinea.getOwner().getName().equals(p2.getName())){
			newGuineaLabel.setFill(Color.RED);
		}
		else {
			newGuineaLabel.setFill(Color.BLACK);
		}
		westernAustraliaLabel.setText(Integer.toString(WesternAustralia.getNumUnits()));
		if(WesternAustralia.getOwner().getName().equals(p1.getName())) {
			westernAustraliaLabel.setFill(Color.BLUE);
		}
		else if (WesternAustralia.getOwner().getName().equals(p2.getName())){
			westernAustraliaLabel.setFill(Color.RED);
		}
		else {
			westernAustraliaLabel.setFill(Color.BLACK);
		}
		easternAustraliaLabel.setText(Integer.toString(EasternAustralia.getNumUnits()));
		if(EasternAustralia.getOwner().getName().equals(p1.getName())) {
			easternAustraliaLabel.setFill(Color.BLUE);
		}
		else if (EasternAustralia.getOwner().getName().equals(p2.getName())){
			easternAustraliaLabel.setFill(Color.RED);
		}
		else {
			easternAustraliaLabel.setFill(Color.BLACK);
		}
	}

	@Override
	/****************************************************************************
	 * Updates the text labels.
	 ***************************************************************************/
	public void initialize(URL location, ResourceBundle resources) {
		updateText();
	}
}
