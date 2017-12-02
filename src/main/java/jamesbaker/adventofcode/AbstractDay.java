package jamesbaker.adventofcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDay {
	public static final Logger LOGGER = LoggerFactory.getLogger(AbstractDay.class);

	public abstract Object calculatePart1(String input);
	public abstract Object calculatePart2(String input);
	
	public void run(String inputFile) {
		LOGGER.info("Part 1 Output: "+calculatePart1(Utils.readResource(inputFile)));
		LOGGER.info("Part 2 Output: "+calculatePart2(Utils.readResource(inputFile)));
	}
}
