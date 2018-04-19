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
		assertTrue(x.isOwned(b));
		assertEquals(x.getKingdomSize(), 1);
		x.removeCountry(a);
		x.removeCountry(b);
		assertEquals(p.getKingdomSize(), 0);
		assertFalse(x.isOwned(b));
		
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
	
	/***********************************************************************
	 * Tests the bot class.
	 **********************************************************************/
	@Test
	public void testBot() {
		Bot b = new Bot("Bot");
		Bot a = new Bot();
		Country c = new Country("c", 1);
		Country d = new Country("d", 1);
		c.addOneNeighbor(d);
		d.addOneNeighbor(c);
		int[] turns = new int[10];
		for (int i = 0; i < turns.length; i++) {
			turns[i] = b.playTurn();
			assertTrue(turns[i] == 1 || turns[i] == -1);
		}
		c.setOwner(a);
		a.addCountry(c);
		d.setOwner(b);
		b.addCountry(d);
		Country e = a.selectAttack();
		assertEquals(e, d);
		Bot x = new Bot();
		Country y = x.selectAttack();
		assertNull(y);
		Bot r = new Bot();
		Country cn = new Country("cn", 1);
		cn.setOwner(r);
		r.addCountry(cn);
		Country s = r.selectAttack();
		assertNull(s);
	}
	
	/***********************************************************************
	 * Tests adding neighbors.
	 **********************************************************************/
	@Test
	public void testNeighbors() {
		Country a = new Country("a", 1);
		Country b = new Country("a", 2);
		Country c = new Country("a", 3);
		Country d = new Country("a", 4);
		Country e = new Country("a", 5);
		Country f = new Country("a", 6);
		Country g = new Country("a", 6);
		a.addOneNeighbor(g);
		assertEquals(a.getNeighbors().length, 1);
		b.addTwoNeighbors(g, a);
		assertEquals(b.getNeighbors().length, 2);
		c.addThreeNeighbors(g, a, b);
		assertEquals(c.getNeighbors().length, 3);
		d.addFourNeighbors(g, a, b, c);
		assertEquals(d.getNeighbors().length, 4);
		e.addFiveNeighbors(g, a, b, c, d);
		assertEquals(e.getNeighbors().length, 5);
		f.addSixNeighbors(g, a, b, c, d, e);
		assertEquals(f.getNeighbors().length, 6);
	}
	
	/**********************************************************************
	 * Tests board.
	 **********************************************************************/
	@Test
	public void testBoard() {
		Board b = new Board();
		Sprite s = b.getSprite();
		assertNotNull(s);
		b.setTurnNum(2);
		assertEquals(b.getTurnNum(), 2);
		Die att = b.getAtt();
		Die def = b.getDef();
		assertNotNull(att);
		assertNotNull(def);
	}
	
	/**********************************************************************
	 * Tests board.
	 **********************************************************************/
	@Test
	public void testSelectNumUnits() {
		Player p = new Player();
		Country a = new Country("a", 1);
		Country b = new Country("b", 1);
		Country c = new Country("c", 1);
		Country d = new Country("d", 1);
		Country e = new Country("e", 1);
		Country f = new Country("f", 1);
		Country g = new Country("g", 1);
		Country h = new Country("h", 1);
		Country i = new Country("i", 1);
		Country j = new Country("j", 1);
		Country k = new Country("k", 1);
		Country l = new Country("l", 1);
		Country m = new Country("m", 1);
		Country n = new Country("n", 1);
		p.addCountry(a);
		assertEquals(p.selectNumUnits(), 3);
		p.addCountry(b);
		p.addCountry(c);
		p.addCountry(d);
		p.addCountry(e);
		p.addCountry(f);
		p.addCountry(g);
		p.addCountry(h);
		p.addCountry(i);
		p.addCountry(j);
		p.addCountry(k);
		p.addCountry(l);
		p.addCountry(m);
		p.addCountry(n);
		assertEquals(p.selectNumUnits(), 4);
	}
	
}


