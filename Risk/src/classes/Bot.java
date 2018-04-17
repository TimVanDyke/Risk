package classes;

import java.util.ArrayList;

/****************************************************************************
 * A class to create a Bot that can play against human players.
 ***************************************************************************/
public class Bot extends Player {

	/***********************************************************************
	 * A constructor for Bot. 
	 * @param name this sets the bot's name.
	 **********************************************************************/
	public Bot(final String name) {
		super(name);
	}
	
	/***********************************************************************
	 * A constructor for bot. 
	 **********************************************************************/
	public Bot() {

	}	
	
	/***********************************************************************
	 * A method to decide what the bot should do on a given turn.
	 * @return an int which will describe what to do
	 **********************************************************************/
	public int playTurn() {
		return 0;
	}
	
	
	
}
