package jamesbaker.adventofcode;

import java.io.IOException;

public class Day1 extends AbstractDay{
	public static void main(String[] args) throws IOException{
		new Day1().run("day1.txt");
	}
	
	@Override
	public Integer calculatePart1(String input) {
		String loopedInput = input + input.substring(0, 1);
		
		Integer total = 0;
		
		for(int i = 0; i < input.length(); i++) {
			Integer curr = toInt(loopedInput.substring(i, i + 1));
			Integer next = toInt(loopedInput.substring(i + 1, i + 2));
			
			if(curr.equals(next))
				total += curr;
		}
		
		return total;
	}
	
	@Override
	public Integer calculatePart2(String input) {
		Integer total = 0;
		
		for(int i = 0; i < input.length(); i++) {
			int halfway = i + input.length() / 2;
			if(halfway >= input.length())
				halfway -= input.length();
			
			Integer curr = toInt(input.substring(i, i + 1));
			Integer next = toInt(input.substring(halfway, halfway + 1));
			
			if(curr.equals(next))
				total += curr;
		}
		
		return total;
	}
	
	private static Integer toInt(String s) {
		return Integer.parseInt(s);
	}

}
