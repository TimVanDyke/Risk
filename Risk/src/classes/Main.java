package classes;

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
	
	/****************************************************************************
	 * The constructor for main. This is called by gui.
	 ***************************************************************************/
	public Main(int width, int height) {
		//makes a screen 
		screen = new Screen(width, height);
		board = new Board();
		p1 = new Player("Tim");
		p2 = new Player("Matt");
		p1.addCountry(board.c1);
		
	}
	public static void main(String[] args) {
		
	}
}