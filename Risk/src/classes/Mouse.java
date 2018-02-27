package classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/****************************************************************************
 * A class to control mouse movement and mouse button presses 
 ***************************************************************************/
public class Mouse implements MouseListener, MouseMotionListener{
	
	/** The x coordinate for the mouse */
	private static int x = -1;
	
	/** The y coordinate for the mouse */
	private static int y = -1;
	
	/** whether or not the mouse is pressed */
	private static int b = -1;
	
	/****************************************************************************
	 * the constructor for Mouse, all it does is change the instance variables
	 * to -1 when it begins.
	 ***************************************************************************/
	public Mouse() {
		x = -1;
		y = -1;
		b = -1;
	}
	
	/****************************************************************************
	 * the getter for the x coordinate
	 * @return x
	 ***************************************************************************/
	public static int getX() {
		return x;
	}
	
	/****************************************************************************
	 * the getter for the y coordinate
	 * @return y
	 ***************************************************************************/
	public static int getY() { 
		return y;
	}
	
	/****************************************************************************
	 * the getter for the b coordinate
	 * @return b
	 ***************************************************************************/
	public static int getB() {
		return b;
	}

	/****************************************************************************
	 * This changes the x and y position of the mouse when the mouse moves
	 ***************************************************************************/
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	/****************************************************************************
	 * updates all variables when the mouse is pressed
	 ***************************************************************************/
	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		b = e.getButton();
	}

	/****************************************************************************
	 * updates b when the mouse is released
	 ***************************************************************************/
	@Override
	public void mouseReleased(MouseEvent e) {
		b = -1;
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
