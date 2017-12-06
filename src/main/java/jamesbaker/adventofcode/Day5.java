package jamesbaker.adventofcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5 extends AbstractDay{
	public static void main(String[] args) throws IOException{
		new Day5().run("day5.txt");
	}
	
	@Override
	public Integer calculatePart1(String input) {
		int currInstruction = 0;
		int steps = 0;
		
		List<Integer> instructions = new ArrayList<>();
		for(String s : input.split("\n"))
			instructions.add(toInt(s));
		
		while(currInstruction >= 0 && currInstruction < instructions.size()) {
			int instruction = instructions.get(currInstruction);
			instructions.set(currInstruction, instruction + 1);
			
			currInstruction += instruction;
			
			steps++;
		}
		
		return steps;
	}
	
	@Override
	public Integer calculatePart2(String input) {
		int currInstruction = 0;
		int steps = 0;
		
		List<Integer> instructions = new ArrayList<>();
		for(String s : input.split("\n"))
			instructions.add(toInt(s));
		
		while(currInstruction >= 0 && currInstruction < instructions.size()) {
			int instruction = instructions.get(currInstruction);
			
			if(instruction >= 3) {
				instructions.set(currInstruction, instruction - 1);
			} else {
				instructions.set(currInstruction, instruction + 1);
			}
			
			currInstruction += instruction;
			
			steps++;
		}
		
		return steps;
	}
	
	private static Integer toInt(String s) {
		return Integer.parseInt(s);
	}
}
