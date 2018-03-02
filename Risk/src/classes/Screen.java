package classes;

/****************************************************************************
 * A class to hold the logic for the screen. This class will make creating 
 * the screen much easier and cleaner int he main method. We also will have 
 * logic to render the board here, as well as all the pieces on top.
 ***************************************************************************/
public class Screen {
	
	/** the width of the screen */
	private int width;
	
	/** the height of the screen */
	private int height;
	
	/** every pixel on the screen */
	private int[] pixels;
	
	/****************************************************************************
	 * the constructor for Screen
	 * @param int width: the width of the screen
	 * @param int height: the height of the screen
	 ***************************************************************************/
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		clear();
	}
	
	/****************************************************************************
	 * this renders the board on GUI,
	 * @param Board board: the board, and this is used to get the board's sprite
	 ***************************************************************************/
	public void renderBoard(Board board) {
		Sprite sp = board.getSprite();
		for (int y = 0; y < sp.getHeight(); y++) {
			for (int x = 0; x < sp.getWidth(); x++) {
				//this basically makes our one dimensional array into 
				pixels[x + (y * width)] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
	}
	
	public void renderCountries(Country[] country) {
		//renders a string to the screen
		Sprite sp = country[0].getSprite();
		for (int y = 0; y < sp.getHeight(); y++) {
			//Offset to find the correct location on screen
			int yOffset = 9;
			for (int x = 0; x < sp.getWidth(); x++) {
				//Offset to find the correct location on screen
				int xOffset = 9;
				pixels[xOffset + yOffset * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
		sp = country[1].getSprite();
		for (int y = 0; y < sp.getHeight(); y++) {
			//Offset to find the correct location on screen
			int yOffset = 18;
			for (int x = 0; x < sp.getWidth(); x++) {
				//Offset to find the correct location on screen
				int xOffset = 274;
				pixels[xOffset + yOffset * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
		sp = country[2].getSprite();
		for (int y = 0; y < sp.getHeight(); y++) {
			//Offset to find the correct location on screen
			int yOffset = 274;
			for (int x = 0; x < sp.getWidth(); x++) {
				//Offset to find the correct location on screen
				int xOffset = 18;
				pixels[xOffset + yOffset * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
		sp = country[3].getSprite();
		for (int y = 0; y < sp.getHeight(); y++) {
			//Offset to find the correct location on screen
			int yOffset = 274;
			for (int x = 0; x < sp.getWidth(); x++) {
				//Offset to find the correct location on screen
				int xOffset = 274;
				pixels[xOffset + yOffset * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
	}
	
	/****************************************************************************
	 * a method to clear the screen by rendering grey over the whole screen
	 ***************************************************************************/
	public void clear() {
		//goes through every pixel setting them to Grey
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0xAAAAAA;
		}
	}
	
	/****************************************************************************
	 * a method to clear the screen by rendering grey over the whole screen
	 ***************************************************************************/
	public int[] getPixels() {
		return pixels;
	}
	
}
