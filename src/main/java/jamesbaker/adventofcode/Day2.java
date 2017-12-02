package jamesbaker.adventofcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 extends AbstractDay{
	public static void main(String[] args) throws IOException{
		new Day2().run("day2.txt");
	}
	
	@Override
	public Integer calculatePart1(String input) {
		Scanner scLine = new Scanner(input);
		
		Integer checkSum = 0;
		while(scLine.hasNextLine()) {
			String line = scLine.nextLine();	
			Scanner scNumber = new Scanner(line);
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			while(scNumber.hasNextInt()) {
				int i = scNumber.nextInt();

				if(i < min)
					min = i;
				
				if(i > max)
					max = i;
			}
			
			LOGGER.debug("Min value: "+min+", Max value: "+max);
			
			scNumber.close();
			checkSum += (max - min);
		}
		
		scLine.close();
		return checkSum;
	}
	
	@Override
	public Integer calculatePart2(String input) {
		Scanner scLine = new Scanner(input);
		
		Integer sum = 0;
		while(scLine.hasNextLine()) {
			String line = scLine.nextLine();	
			Scanner scNumber = new Scanner(line);

			List<Integer> previousNumbers = new ArrayList<>();
			while(scNumber.hasNextInt()) {
				int i = scNumber.nextInt();

				for(Integer j : previousNumbers) {
					if(i % j == 0) {
						sum += i / j;
					}else if(j % i == 0) {
						sum += j / i;
					}
				}
				
				previousNumbers.add(i);
			}
			
			scNumber.close();
		}
		
		scLine.close();
		return sum;
	}
}
