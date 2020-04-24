package fi.johanneslares.luolastogeneraattori.map;

import static org.junit.Assert.*;

import org.junit.Test;

public class AngledPathPositionsTest {

	@Test
	public void angledPathPositionsTest() {
		AngledPathPositions p = new AngledPathPositions(3, 8, 1200, 80, "tl");
		assertTrue(p.getStartX() == 3);
		assertTrue(p.getStartY() == 8);
		assertTrue(p.getStartXcoordY() == 1200);
		assertTrue(p.getStartYcoordX() == 80);
		assertTrue(p.getType().equals("tl"));
	}

}
