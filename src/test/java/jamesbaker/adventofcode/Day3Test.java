package jamesbaker.adventofcode;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day3Test {
	@Test
	public void testPart1() {
		assertEquals(Integer.valueOf(0), new Day3().calculatePart1("1"));
		assertEquals(Integer.valueOf(3), new Day3().calculatePart1("12"));
		assertEquals(Integer.valueOf(2), new Day3().calculatePart1("23"));
		assertEquals(Integer.valueOf(31), new Day3().calculatePart1("1024"));
	}
	
	@Test
	public void testPart2() {
		assertEquals(Integer.valueOf(54), new Day3().calculatePart2("50"));
		assertEquals(Integer.valueOf(806), new Day3().calculatePart2("800"));
	}
}
