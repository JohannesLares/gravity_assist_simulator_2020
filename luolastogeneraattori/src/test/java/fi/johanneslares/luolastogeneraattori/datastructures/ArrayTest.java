package fi.johanneslares.luolastogeneraattori.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest {

	@Test(expected=IndexOutOfBoundsException.class)
	public void testArrayThrowsError() {
		Array<Integer> list = new Array<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.get(-1);
	}
	
	@Test
	public void testArrayReturnsCorrectValue() {
		Array<Integer> list = new Array<Integer>();
		for (int i = 0; i < 30; i++) {
			list.add(i);
		}
		assertTrue(3 == list.get(3));
		assertTrue(10 == list.get(10));
		assertTrue(20 == list.get(20));
		assertTrue(28 == list.get(28));
	}
	
	@Test
	public void performanceTest() {
		long time = System.nanoTime();
		Array<Integer> list = new Array<Integer>();
		for (int i = 0; i < 1000; i++) {
			list.add(i*8);
		}
		long endTime = System.nanoTime();
		System.out.println("Time to create Array and adding 1000 elements (ns): " + (endTime-time));
		int a = 0;
		time = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			a=list.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("Time to get elements from 1000 element Array (ns): " + (endTime-time));
	}

}
