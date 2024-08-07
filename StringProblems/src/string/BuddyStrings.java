package string;

/**
 * Given two strings s and goal, return true if you can swap two letters in s so
 * the result is equal to goal, otherwise, return false.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BuddyStrings {

	public static void main(String[] args) {
		String s = "ab";
		String goal = "ba";
		System.out.println(buddyStrings(s, goal));
	}

	public static boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		if (s.equals(goal)) {
			int[] chars = new int[26];
			for (char c : s.toCharArray()) {
				chars[c - 'a']++;
				if (chars[c - 'a'] > 1) {
					return true;
				}
			}
			return false;
		}
		int first = -1;
		int second = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				if (first == -1) {
					first = i;
				} else if (second == -1) {
					second = i;
				} else {
					return false;
				}
			}
		}
		return second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
	}
}
