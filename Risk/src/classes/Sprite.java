package classes;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/****************************************************************************
 * A class to hold the logic for loading sprites, as well as hold their 
 * file paths for certain sprites. 
 ***************************************************************************/
public class Sprite {
	
	/** The path to the sprite in /res. */
	private String path;
	
	/** each pixel in the image. */
	private int[] pixels;
	
	/** the width of the image. */
	private int width;
	
	/** the height of the image. */
	private int height;
	
	/** testBoard can be used anywhere as a sprite. */
	public static Sprite testBoard = new Sprite("res/testBoard.png");
	public static Sprite highlight = new Sprite("res/highlight.png");
	public static Sprite highlight_att = new Sprite("res/highlight_att.png");
	
	/***********************************************************************
	 * the constructor for sprite this calls the load function.
	 * @param String filename: the path for the sprite.
	 **********************************************************************/
	public Sprite (String filename) {
		path = filename;
		load();
	}
	
	/***********************************************************************
	 * This method tries to open the image file and then sets all the 
	 * variables according to the image file that opens.
	 **********************************************************************/
	private void load() {
		try {
			//Loads the image into "image"
			BufferedImage image = 
					ImageIO.read(new FileInputStream(path));
			width = image.getWidth();
			height = image.getHeight();
			//Sets size
			pixels = new int[width * height];
			//Sets pixels
			image.getRGB(0, 0, width, height, pixels, 0, width);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("");
		}
	}

	/***********************************************************************
	 * @return the pixels.
	 **********************************************************************/
	public int[] getPixels() {
		return pixels;
	}

	/***********************************************************************
	 * @return the width.
	 **********************************************************************/
	public int getWidth() {
		return width;
	}

	/***********************************************************************
	 * @return the height.
	 **********************************************************************/
	public int getHeight() {
		return height;
	}
}
