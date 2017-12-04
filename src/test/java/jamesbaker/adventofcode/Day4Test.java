package jamesbaker.adventofcode;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day4Test {
	@Test
	public void testPart1() {
		assertEquals(2, new Day4().calculatePart1("aa bb cc dd ee\naa bb cc dd aa\naa bb cc dd aaa"));
	}
	
	@Test
	public void testPart2() {
		assertEquals(3, new Day4().calculatePart2("abcde fghij\n"
				+ "abcde xyz ecdab\n"
				+ "a ab abc abd abf abj\n"
				+ "iiii oiii ooii oooi oooo\n"
				+ "oiii ioii iioi iiio"));
	}
}
