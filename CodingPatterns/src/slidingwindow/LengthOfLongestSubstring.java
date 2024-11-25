package slidingwindow;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating
 * characters. Time Complexity: O(n) Space Complexity:  O(min(m,n))
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "abcabcab";
		if (s == null || s.length() == 0)
			System.out.println(0);

		HashMap<Character, Integer> charIndexMap = new HashMap<>();
		int maxLength = 0;
		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);

			// If the character is already in the map, move the left pointer
			// right after the previous occurrence of the current character
			if (charIndexMap.containsKey(currentChar)) {
				left = Math.max(left, charIndexMap.get(currentChar) + 1);
			}

			// Update the map with the current character's latest index
			charIndexMap.put(currentChar, right);

			// Calculate the length of the current substring
			maxLength = Math.max(maxLength, right - left + 1);
		}
		System.out.println(maxLength);
	}

}
