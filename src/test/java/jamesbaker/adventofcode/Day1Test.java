package jamesbaker.adventofcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day1Test {
	@Test
	public void testPart1() {
		Day1 day1 = new Day1();
		
		assertEquals(Integer.valueOf(3), day1.calculatePart1("1122"));
		assertEquals(Integer.valueOf(4), day1.calculatePart1("1111"));
		assertEquals(Integer.valueOf(0), day1.calculatePart1("1234"));
		assertEquals(Integer.valueOf(9), day1.calculatePart1("91212129"));
	}
	
	@Test
	public void testPart2() {
		Day1 day1 = new Day1();
		
		assertEquals(Integer.valueOf(6), day1.calculatePart2("1212"));
		assertEquals(Integer.valueOf(0), day1.calculatePart2("1221"));
		assertEquals(Integer.valueOf(4), day1.calculatePart2("123425"));
		assertEquals(Integer.valueOf(12), day1.calculatePart2("123123"));
		assertEquals(Integer.valueOf(4), day1.calculatePart2("12131415"));
	}
}
