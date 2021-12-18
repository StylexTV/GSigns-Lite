package de.stylextv.gsigns.command.argument;

public class ArgumentHelper {
	
	private static final String INT_REGEX = "-?\\d+";
	
	private static final String NUMERIC_REGEX = "-?\\d+(\\.\\d+)?";
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static float toFloat(String s) {
		return Float.parseFloat(s);
	}
	
	public static boolean isInt(String s) {
		return s.matches(INT_REGEX);
	}
	
	public static boolean isNumeric(String s) {
		return s.matches(NUMERIC_REGEX);
	}
	
}
