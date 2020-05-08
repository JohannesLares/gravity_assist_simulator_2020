package fi.johanneslares.luolastogeneraattori;

import static org.junit.Assert.*;


import org.junit.Test;

public class PerformanceTest {

	@Test
	public void test() {
		long time = System.nanoTime();
		App.run(100, 100, false, false);
		long endTime = System.nanoTime();
		System.out.println("Time to create 100x100 cave (ns): " + (endTime-time));
		time = System.nanoTime();
		App.run(1000, 100, false, false);
		endTime = System.nanoTime();
		System.out.println("Time to create 1000x100 cave (ns): " + (endTime-time));
		time = System.nanoTime();
		App.run(1000, 1000, false, false);
		endTime = System.nanoTime();
		System.out.println("Time to create 1000x1000 cave (ns): " + (endTime-time));
		time = System.nanoTime();
		App.run(10000, 1000, false, false);
		endTime = System.nanoTime();
		System.out.println("Time to create 10000x1000 cave (ns): " + (endTime-time));
		time = System.nanoTime();
		App.run(10000, 10000, false, false);
		endTime = System.nanoTime();
		System.out.println("Time to create 10000x10000 cave (ns): " + (endTime-time));
		assertTrue(true);
	}

}
