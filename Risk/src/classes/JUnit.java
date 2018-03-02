package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnit {

	@Test
	public void testDice() {
		Die a = new Die();
		Die b = new Die(10, 20);
		assertTrue(a.Roll() > 0 && a.Roll() < 7);
		assertTrue(b.Roll() > 9 && b.Roll() < 21);
	}
	
	@Test
	public void testAttack(){
		String a = "hi";
		Board b = new Board();
		Country att = new Country("att", 1);
		Country def = new Country("def", 1);
		att.setNumUnits(2);
		def.setNumUnits(1);
		assertTrue(att.getNumUnits() == 2 && def.getNumUnits() == 1);
		Die attDice[] = new Die[1];
		Die defDice[] = new Die[1];
		b.setAtt(attDice);
		b.setDef(defDice);
		assertTrue(b.getAtt() == attDice && b.getDef() == defDice);
		b.attack(att, def, attDice, defDice);
		assertTrue(att.getNumUnits() != 1 || def.getNumUnits() != 1);
	}
	

}
