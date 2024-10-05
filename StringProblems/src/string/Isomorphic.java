package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * Time Complexity:  O(n)  space complexity:  O(1) 
 */
public class Isomorphic {

	public static void main(String[] args) {
		String s = "bbbaaaba";
		String t = "aaabbbba";
		System.out.println(isIsomorphic(s, t));
	}

	static boolean isIsomorphic(String s, String t) {

		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		if (s.length() != t.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			int sCount = sMap.getOrDefault(s.charAt(i), 0);
			int tCount = tMap.getOrDefault(t.charAt(i), 0);
			if (sCount != tCount) {
				return false;
			}
			sMap.put(s.charAt(i), i + 1);
			tMap.put(t.charAt(i), i + 1);
		}
		return true;
	}
}
