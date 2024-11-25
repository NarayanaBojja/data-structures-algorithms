package recursion;

/**
 * Given a string, find all the possible subsequences of the string.
 * https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/
 * Time Complexity: O(2^n) Space Complexity: O(n) (in the worst case) or O(1)
 * (if considering the character set size as constant)
 * 
 */
public class GenerateSubsequences {

	public static void main(String[] args) {
		String s = "abc";
		String f = "";
		System.out.println("All possible subsequences are: ");
		subSequences(0, s, f);
	}

	static void subSequences(int i, String s, String f) {
		if (i == s.length()) {
			System.out.print(f + " ");
			return;
		}
		// picking
		// f = f + s.charAt(i);
		subSequences(i + 1, s, f + s.charAt(i));
		// poping out while backtracking
		// f.pop_back();
		subSequences(i + 1, s, f);
	}
}
