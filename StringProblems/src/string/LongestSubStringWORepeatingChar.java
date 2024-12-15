package string;

/**
 * Given a String, find the length of longest substring without any repeating
 * character.
 * https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
 * Time Complexity: O(n) space complexity: O(1)
 */
public class LongestSubStringWORepeatingChar {

	public static void main(String[] args) {
		String s = "abcabcbb";
		int n = s.length();

		int[] arr = new int[128];
		for (int i = 0; i < n; i++) {
			arr[i] = -1;
		}
		int res = 0;
		int start = 0;
		for (int end = 0; end < n; end++) {
			start = Math.max(start, arr[s.charAt(end)] + 1);
			res = Math.max(res, end - start + 1);
			arr[s.charAt(end)] = end;
		}
		System.out.println("Length of LongestSubStringWORepeatingChar " + res);
	}

}
