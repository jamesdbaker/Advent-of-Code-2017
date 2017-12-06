package jamesbaker.adventofcode;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day5Test {
	@Test
	public void testPart1() {
		assertEquals(Integer.valueOf(5), new Day5().calculatePart1("0\n3\n0\n1\n-3"));
	}
	
	@Test
	public void testPart2() {
		assertEquals(Integer.valueOf(10), new Day5().calculatePart2("0\n3\n0\n1\n-3"));

	}
}
