package jamesbaker.adventofcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day2Test {
	@Test
	public void testPart1() {
		assertEquals(Integer.valueOf(18), new Day2().calculatePart1("5 1 9 5\n7 5 3\n2 4 6 8"));
	}
	
	@Test
	public void testPart2() {
		assertEquals(Integer.valueOf(9), new Day2().calculatePart2("5 9 2 8\n9 4 7 3\n3 8 6 5"));
	}
}
