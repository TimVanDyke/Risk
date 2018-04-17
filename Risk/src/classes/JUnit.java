package classes;

import static org.junit.Assert.*;

import org.junit.Test;

/****************************************************************************
 * A class to test our program.
 ***************************************************************************/
public class JUnit {

	/***********************************************************************
	 * Tests our die class.
	 **********************************************************************/
	@Test
	public void testDice() {
		Die a = new Die();
		Die b = new Die(10, 20);
		assertTrue(a.roll() > 0 && a.roll() < 7);
		assertTrue(b.roll() > 9 && b.roll() < 21);
	}
	
	/***********************************************************************
	 * Tests our attack method in board.
	 **********************************************************************/
	@Test
	public void testAttack() {
		Board board = new Board();
		Player p = new Player("P1");
		Player q = new Player("P2");
		Country att = new Country("att", 1);
		Country def = new Country("def", 1);
		att.setNumUnits(41);
		def.setNumUnits(1);
		p.addCountry(att);
		q.addCountry(def);
		att.setOwner(p);
		def.setOwner(q);
		board.attack(att, def, 6, 1);
		assertEquals(att.getNumUnits(), 1);
		assertEquals(def.getNumUnits(), 40);
		
		att.setNumUnits(15);
		def.setNumUnits(15);
		p.addCountry(att);
		q.addCountry(def);
		att.setOwner(p);
		def.setOwner(q);
		board.attack(att, def, 1, 6);
		assertEquals(att.getNumUnits(), 14);
		assertEquals(def.getNumUnits(), 15);
		
		att.setNumUnits(15);
		def.setNumUnits(15);
		p.addCountry(att);
		q.addCountry(def);
		att.setOwner(p);
		def.setOwner(q);
		board.attack(att, def, 6, 1);
		assertEquals(att.getNumUnits(), 15);
		assertEquals(def.getNumUnits(), 14);
		
	}
	
	/***********************************************************************
	 * Tests our checkResults method in board.
	 **********************************************************************/
	@Test
	public void testCheckResults() {
		Board board = new Board();
		Player p = new Player("P1");
		Player q = new Player("P2");
		Country att = new Country("att", 1);
		Country def = new Country("def", 1);
		att.setNumUnits(40);
		def.setNumUnits(1);
		p.addCountry(att);
		q.addCountry(def);
		Country[] c = new Country[42];
		for (int i = 0; i < 40; i++) {
			c[i] = new Country();
			p.addCountry(c[i]);
			c[i].setOwner(p);
		}
		att.setOwner(p);
		def.setOwner(q);
		board.attack(att, def, 6, 1);
		assertEquals(p.getKingdomSize(), 42);
		assertEquals(q.getKingdomSize(), 0);
	}
	
	/***********************************************************************
	 * Tests the player class.
	 **********************************************************************/
	@Test
	public void testPlayer() {
		Player p = new Player("P1");
		String s = "";
		Country a = new Country("a", 1, s);
		p.addCountry(a);
		assertEquals(p.getKingdomSize(), 1);
		p.removeCountry(a);
		assertEquals(p.getKingdomSize(), 0);
		assertTrue(p.isInGame());
		assertNotNull(p.getName());
		
		Player x = new Player();
		x.setName("P2");
		Country b = new Country("b", 1);
		x.addCountry(b);
		assertEquals(x.getKingdomSize(), 1);
		x.removeCountry(a);
		x.removeCountry(b);
		assertEquals(p.getKingdomSize(), 0);
	}
	
	/***********************************************************************
	 * Tests the country class.
	 **********************************************************************/
	@Test
	public void testCountry() {
		Country c = new Country("c", 6);
		c.setNumUnits(5);
		c.setNumUnits("null", 5);
		assertEquals(c.getNumUnits(), 5);
		c.setNumUnits("sub", 2);
		assertEquals(c.getNumUnits(), 3);
		c.setNumUnits("add", 2);
		assertEquals(c.getNumUnits(), 5);
		assertEquals(c.getName(), "c");
		assertEquals(c.getSprite(), null);
	}
	

}
