package ru.rsreu.carservice.model.entities;

public class Separator {
	private static final String PHRASES_SEPARATOR = ", ";
	private static final String WORDS_SEPARTATOR = ":";
	private static final int VALUE_INDEX = 1;

	public static String[] getValues(String input) {
		String[] phrases = input.split(PHRASES_SEPARATOR);
		String[] values = new String[phrases.length];
		int index = 0;
		for (String phrase : phrases) {
			String[] words = phrase.split(WORDS_SEPARTATOR);
			values[index++] = words[VALUE_INDEX];
		}
		return values;
	}
}
