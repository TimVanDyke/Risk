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
		setAtt(new Die[3]);
		setDef(new Die[2]);
		
		for (int i = 0; i < att.length; i++)
			att[i] = new Die();
		
		for (int i = 0; i < def.length; i++)
			def[i] = new Die();
		
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
	 * @param Country attacker: the attacking country
	 * @param Country defender: the defending country
	 * @param attackerDice: number of dice the attacker is using
	 * @param defenderDice: number of dice the defender is using
	 ***************************************************************************/
	public void attack(Country attacker, 
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
		
		//Compare the dice rolls
		int result = 0;
		for(int i=0; i<defenderRoll.length; i++){
			if(attackerRoll[i] > defenderRoll[i]){
				result++;
			}
			else{
				result--;
			}
		}
		
		//Used to see if defender will lose control of a country.
		int temp = defender.getNumUnits();
		//Positive numbers mean attacker wins, negative means defender wins
		switch(result){
		case -2:
			attacker.setNumUnits("sub", 2);
			break;
		case -1:
			attacker.setNumUnits("sub", 1);
			break;
		case 0:
			if (temp - 1 <= 0){
				defender.getOwner().removeCountry(defender);
				attacker.getOwner().addCountry(defender);
				//Also need to add some units to new country. Player's choice.
			}
			else{
				defender.setNumUnits("sub", 1);
				attacker.setNumUnits("sub", 1);
			}
			break;
		case 1:
			if (temp - 1 <= 0){
				//Checks to see if defender is about to lose
				if(defender.getOwner().getKingdomSize() == 1){
					defender.getOwner().lose();
				}
				defender.getOwner().removeCountry(defender);
				attacker.getOwner().addCountry(defender);
				//Checks to see if attacker won
				if(attacker.getOwner().getKingdomSize() == 42){
					attacker.getOwner().winner();
				}
				//Also need to add some units to new country. Player's choice.
			}
			else{
				defender.setNumUnits("sub", 1);
			}
			break;
		case 2:
			if (temp - 2 <= 0){
				//Checks to see if defender is about to lose
				if(defender.getOwner().getKingdomSize() == 1){
					defender.getOwner().lose();
				}
				defender.getOwner().removeCountry(defender);
				attacker.getOwner().addCountry(defender);
				//Checks to see if attacker won
				if(attacker.getOwner().getKingdomSize() == 42){
					attacker.getOwner().winner();
				}
				//Also need to add some units to new country. Player's choice.
			}
			else{
				defender.setNumUnits("sub", 2);
			}
			break;
		}
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
			i++;
		}
	}

	
	/****************************************************************************
	 * @return the attackers die array
	 ***************************************************************************/
	public Die[] getAtt() {
		return att;
	}

	/****************************************************************************
	 * @param the attackers die array
	 ***************************************************************************/
	public void setAtt(Die[] att) {
		this.att = att;
	}

	/****************************************************************************
	 * @return the defenders die array
	 ***************************************************************************/
	public Die[] getDef() {
		return def;
	}

	/****************************************************************************
	 * @param the defenders die array
	 ***************************************************************************/
	public void setDef(Die[] def) {
		this.def = def;
	}
}