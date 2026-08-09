package greedy;

/**
 * Whenever two adjacent characters are equal, make one change immediately and
 * skip the next character. Time: O(n) per word Space: O(1)
 */
public class MinAdjustments {

	public static void main(String[] args) {
		String word = "aaabbc";
		int changes = 0;

		for (int i = 1; i < word.length();) {

			if (word.charAt(i) == word.charAt(i - 1)) {
				changes++;
				i += 2; // skip the character we conceptually replace
			} else {
				i++;
			}
		}
		System.out.println("Min changes required: " + changes);
	}

}
