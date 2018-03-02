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
		Player p = new Player("P1");
		Player q = new Player("P2");
		Board b = new Board();
		Country att = new Country("att", 1);
		Country def = new Country("def", 1);
		att.setNumUnits(2);
		def.setNumUnits(1);
		p.addCountry(att);
		q.addCountry(def);
		assertTrue(att.getNumUnits() == 2 && def.getNumUnits() == 1);
		Die attDice[] = new Die[3];
		Die defDice[] = new Die[2];
		for (int i = 0; i < attDice.length; i++)
			attDice[i] = new Die();
		
		for (int i = 0; i < defDice.length; i++)
			defDice[i] = new Die();
		b.setAtt(attDice);
		b.setDef(defDice);
		assertTrue(b.getAtt() == attDice && b.getDef() == defDice);
		b.attack(att, def, attDice, defDice);
		assertTrue(att.getNumUnits() != 1 || def.getNumUnits() != 1);
	}
	
	@Test
	public void testPlayer(){
		Player p = new Player("P1");
		Country a = new Country("a", 1);
		p.addCountry(a);
		assertTrue(p.getKingdomSize()==1);
		p.removeCountry(a);
		assertTrue(p.getKingdomSize()==0);
		assertTrue(p.isInGame() == true);
		assertNotNull(p.getName());
		
		
	}
	

}
