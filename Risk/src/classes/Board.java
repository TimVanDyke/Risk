package classes;

import java.util.*;

/****************************************************************************
 * A class to hold the countries and dice. This also has 
 * the logic to move and attack from one country to another
 ***************************************************************************/
public class Board {
	
	/** the number of turns played */
	int turnNum;
	
	/** the dice for the attacker */
	private Die[] att;
	
	/** the dice for the defender */
	private Die[] def;
	
	/** the sprite for the board */
	private Sprite sprite;
	
	/****************************************************************************
	 * The constructor for the board class
	 ***************************************************************************/
	public Board() {
		
		//instantiating turnNumber
		turnNum = 0;
		
		//instantiating attacker and defender dice
		att = new Die[3];
		def = new Die[2];
		
		//sets sprite
		sprite = Sprite.testBoard;
		
		//after testing sets sprite
		//sprite = Sprite.board;
	}
	
	/****************************************************************************
	 * @return the sprite for the board
	 ***************************************************************************/
	public Sprite getSprite() {
		return sprite;
	}

	
	/****************************************************************************
	 * The attack method
	 * @param FIXME
	 * @param FIXME
	 * @param FIXME
	 ***************************************************************************/
	public Player attack(Player att, Player def, Country attacker, 
			Country defender, Die[] attackerDice, Die[] defenderDice) {
		
		int[] attackerRoll = new int[3];
		int[] defenderRoll = new int[2];
		
		for(int i=0;i<attackerDice.length; i++){
			attackerRoll[i]=attackerDice[i].Roll();
		}
		for(int i=0;i<defenderDice.length; i++){
			defenderRoll[i]=defenderDice[i].Roll();
		}
		//Sort dice rolls in descending order
		Arrays.sort(attackerRoll);
		Arrays.sort(defenderRoll);
		reverse(attackerRoll);
		reverse(defenderRoll);
		
		
		
		Player winner = att;
		return winner;
	}
	
	/****************************************************************************
	 * Reverse array method
	 * @param an array arr to be reversed
	 ***************************************************************************/
	private void reverse(int[] arr){
		int i = 0;
		int j = arr.length-1;
		while(i < j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
}