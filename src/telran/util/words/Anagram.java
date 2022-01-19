package telran.util.words;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
/**
 * 
 * @param word
 * @param anagram
 * @return true if anagram contains a word comprising of only all letters from a given word (case insensitive)
 * implementation requirements: O[N], using only one map and two passing's over (one is over word and other is over anagram)
 */
	public static boolean isAnagram(String word, String anagram) {
		boolean res = false;
	if (word.length() == anagram.length()) {
		Map<Character, Integer> mapLetters = getMap(word);
		res = isAnagram(mapLetters, anagram);
	}
	return res;
}

private static boolean isAnagram(Map<Character, Integer> mapLetters, String anagram) {
	for(char letter: anagram.toLowerCase().toCharArray()) {
		if (mapLetters.merge(letter, -1, (a, b) -> a + b) == -1) {
			return false;
		}
	}
	return true;
}

private static Map<Character, Integer> getMap(String word) {
	HashMap<Character, Integer> resMap = new HashMap<>();
	for(char letter: word.toLowerCase().toCharArray()) {
		resMap.merge(letter, 1, (a, b) -> a + b);
	}
	return resMap;
}
}
