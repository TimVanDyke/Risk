package classes;

/****************************************************************************
 *A class to hold the countries and dice. This also has
 *the logic to move and attack from one country to another.
 ***************************************************************************/
public class Board {

    /** the number of turns played. */
    private int turnNum;

    /** the dice for the attacker. */
    private Die att;

    /** the dice for the defender. */
    private Die def;

    /** the sprite for the board. */
    private Sprite sprite;

    /***********************************************************************
	 * The constructor for the board class.
	 **********************************************************************/
	public Board() {
		
		//instantiating turnNumber
		turnNum = 0;
		
		//instantiating attacker and defender dice
		setAtt(new Die());
		setDef(new Die());
		
//		for (int i = 0; i < att.length; i++)
//			att[i] = new Die();
//		
//		for (int i = 0; i < def.length; i++)
//			def[i] = new Die();
		
		//sets sprite
		sprite = Sprite.testBoard;
		
		//after testing sets sprite
		//sprite = Sprite.board;
	}
	
	/***********************************************************************
	 * @return the number of the turn
	 **********************************************************************/
	public int getTurnNum() {
		return turnNum;
	}

	/***********************************************************************
	 * @param turnNum to set the number of the turn
	 **********************************************************************/
	public void setTurnNum(final int turnNum) {
		this.turnNum = turnNum;
	}

	/***********************************************************************
	 * @return the sprite for the board.
	 **********************************************************************/
	public Sprite getSprite() {
		return sprite;
	}
	
	/***********************************************************************
	 * The method used to attack another country.
	 * @param attacker the attacking country.
	 * @param defender the defending country.
	 * @param attRoll the attacker's die.
	 * @param defRoll the defender's die.
	 * @return results: an array holding the dice rolls.
	 * so they can be shown in the GUI.
	 **********************************************************************/
	public int[] attack(final Country attacker, final Country defender, 
			final int attRoll, final int defRoll) {
		//FIXME Make variables in new gui that will display what 
		//each person rolled.
		//FIXME Maybe in GUI, check to make sure attacker has 
		//at least 2 unit son the country
		//FIXME Rolling now done in GUI, makes it much easier for 
		//testing since I can now control the roll result.
		
		int[] results = new int[2];
		results[0] = attRoll;
		results[1] = defRoll;
		
		//Compare roll results
		//If attacker wins
		if (results[0] > results[1]) {
			if (defender.getNumUnits() == 1) {
				defender.getOwner().removeCountry(defender);
				attacker.getOwner().addCountry(defender);
				//Moves all units to new country except 1
			    defender.setNumUnits(attacker.getNumUnits() - 1);
				//Leaves 1 unit at old attacker
				attacker.setNumUnits(1);
			} else {
                defender.setNumUnits(defender.getNumUnits() - 1);
			}
		}
		//If defender wins
		//Tie goes to defender
		if (results[0] <= results[1]) {
			attacker.setNumUnits(attacker.getNumUnits() - 1);
		}
		checkResults(attacker, defender, results);
		return results;
	}
	
	/***********************************************************************
	 * Check to see if we have a winner or loser.
	 * @param attacker the attacking country.
	 * @param defender the defending country.
	 * @param results the die rolls.
	 **********************************************************************/
	private void checkResults(final Country attacker, 
			final Country defender, final int[] results) {	
		//Check to see if someone won or lost the game
			if (attacker.getOwner().getKingdomSize() == 42) {
				attacker.getOwner().winner(); 
			}
			if (defender.getOwner().getKingdomSize() == 0) {
				defender.getOwner().lose();
			}

		}
	
//	/***********************************************************************
//	 * The attack method.
//	 * @param attacker: the attacking country.
//	 * @param defender: the defending country.
//	 * @param attackerDice: number of dice the attacker is using.
//	 * @param defenderDice: number of dice the defender is using.
//	 **********************************************************************/
//	public void attack(Country attacker, Country defender, 
//			Die attackerDie, Die defenderDie) {
//		
//			int[] attackerRoll = new int[3];
//			int[] defenderRoll = new int[2];
//		
//			for(int i=0;i<attackerDie.length; i++){
//			attackerRoll[i] = attackerDie[i].Roll();
//			}
//			for(int i=0;i<defenderDie.length; i++){
//			defenderRoll[i] = defenderDie[i].Roll();
//			}
//		
//			//Sort dice rolls in descending order
//			Arrays.sort(attackerRoll);
//			Arrays.sort(defenderRoll);
//			reverse(attackerRoll);
//			reverse(defenderRoll);
//		
//			//Compare the dice rolls
//			int result = 0;
//			for(int i=0; i<defenderRoll.length; i++){
//				if(attackerRoll[i] > defenderRoll[i]){
//				result++;
//			}
//			else{
//				result--;
//			}
//		}
//		
//		//Used to see if defender will lose control of a country.
//		int temp = defender.getNumUnits();
//	    Positive numbers mean attacker wins, negative means defender wins
//		switch(result){
//		case -2:
//			attacker.setNumUnits("sub", 2);
//			break;
//		case -1:
//			attacker.setNumUnits("sub", 1);
//			break;
//		case 0:
//			if (temp - 1 <= 0){
//				defender.getOwner().removeCountry(defender);
//				attacker.getOwner().addCountry(defender);
//			    Also need to add some units to new country. 
//              Player's choice.
//			}
//			else{
//				defender.setNumUnits("sub", 1);
//				attacker.setNumUnits("sub", 1);
//			}
//			break;
//		case 1:
//			if (temp - 1 <= 0){
//				//Checks to see if defender is about to lose
//				if(defender.getOwner().getKingdomSize() == 1){
//					defender.getOwner().lose();
//				}
//				defender.getOwner().removeCountry(defender);
//				attacker.getOwner().addCountry(defender);
//				//Checks to see if attacker won
//				if(attacker.getOwner().getKingdomSize() == 42){
//					attacker.getOwner().winner();
//				}
//    		   	Also need to add some units to new country. 
//              Player's choice.
//			}
//			else{
//				defender.setNumUnits("sub", 1);
//			}
//			break;
//		case 2:
//			if (temp - 2 <= 0){
//				//Checks to see if defender is about to lose
//				if(defender.getOwner().getKingdomSize() == 1){
//					defender.getOwner().lose();
//				}
//				defender.getOwner().removeCountry(defender);
//				attacker.getOwner().addCountry(defender);
//				//Checks to see if attacker won
//				if(attacker.getOwner().getKingdomSize() == 42){
//					attacker.getOwner().winner();
//				}
//              Also need to add some units to new country. 
//              Player's choice.			}
//			else{
//				defender.setNumUnits("sub", 2);
//			}
//			break;
//		}
//	}
//	
//	/***********************************************************************
//	 * Reverse array method.
//	 * @param an array arr to be reversed.
//	 **********************************************************************/
//	private void reverse(int[] arr){
//		int i = 0;
//		int j = arr.length-1;
//		while(i < j){
//			int temp = arr[i];
//			arr[i] = arr[j];
//			arr[j] = temp;
//			i++;
//		}
//	}

	
	/***********************************************************************
	 * @return the attackers die.
	 **********************************************************************/
	public Die getAtt() {
		return att;
	}

	/***********************************************************************
	 * @param att the attackers die.
	 **********************************************************************/
	public void setAtt(final Die att) {
		this.att = att;
	}

	/***********************************************************************
	 * @return the defenders die.
	 **********************************************************************/
	public Die getDef() {
		return def;
	}

	/***********************************************************************
	 * @param def the defenders die.
	 **********************************************************************/
	public void setDef(final Die def) {
		this.def = def;
	}
	/***********************************************************************
<<<<<<< HEAD
	 * 
=======
	 * saves the game
>>>>>>> branch 'master' of https://github.com/TimVanDyke/Risk.git
	 **********************************************************************/
	public void save() {
		System.out.println("saved");
	}
	/***********************************************************************
	 * loads the game
	 **********************************************************************/
	public void load() {
		System.out.println("loaded");
	}
}

