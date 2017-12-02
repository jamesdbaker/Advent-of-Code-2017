package jamesbaker.adventofcode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	private Utils() {}

	public static String readResource(String fileName) {
		ClassLoader classLoader = Utils.class.getClassLoader();
		try {
			return IOUtils.toString(classLoader.getResourceAsStream(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			LOGGER.error("Unable to read resource", e);
			return null;
		}
	}
}
