package hashing;

/**
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * TC: O(n), SC: O(1) 
 * 
 */
public class FirstUniqChar {

	public static void main(String[] args) {
		String s = "leetcode";
		int[] freqArray = new int[26];
		for (char ch : s.toCharArray()) {
			freqArray[ch - 'a']++;
		}
		int i = -1;
		for (char ch : s.toCharArray()) {
			if (freqArray[ch - 'a'] == 1) {
				i++;
				System.out.println("index: " + i);
				return;
			}
			i++;
		}
		System.out.println("No char: " + i);
	}

}
