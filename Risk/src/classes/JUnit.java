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

}
