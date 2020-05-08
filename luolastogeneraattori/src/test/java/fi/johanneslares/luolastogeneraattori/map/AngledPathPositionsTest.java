package fi.johanneslares.luolastogeneraattori.map;

import static org.junit.Assert.*;

import org.junit.Test;

public class AngledPathPositionsTest {

	@Test
	public void angledPathPositionsTest() {
		AngledPathPositions p = new AngledPathPositions(3, 8, 1200, 80);
		assertTrue(p.getRoom1X() == 3);
		assertTrue(p.getRoom1Y() == 8);
		assertTrue(p.getRoom2X() == 1200);
		assertTrue(p.getRoom2Y() == 80);
	}

}
