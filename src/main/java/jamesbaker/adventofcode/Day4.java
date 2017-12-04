package jamesbaker.adventofcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day4 extends AbstractDay {

	@Override
	public Object calculatePart1(String input) {
		Scanner scLine = new Scanner(input);

		int count = 0;
		while(scLine.hasNextLine()) {
			String[] words = scLine.nextLine().split(" ");
			Set<String> wordSet = new HashSet<>();

			wordSet.addAll(Arrays.asList(words));

			if(words.length == wordSet.size())
				count++;
		}

		scLine.close();

		return count;
	}

	@Override
	public Object calculatePart2(String input) {
		Scanner scLine = new Scanner(input);

		int count = 0;
		while(scLine.hasNextLine()) {
			String[] words = scLine.nextLine().split(" ");
			Set<String> wordSet = new HashSet<>();

			Arrays.asList(words).forEach(s -> wordSet.add(sortString(s)));

			if(words.length == wordSet.size())
				count++;
		}

		scLine.close();

		return count;
	}

	public static String sortString(String inputString){
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}

	public static void main(String[] args) {
		new Day4().run("day4.txt");
	}

}
