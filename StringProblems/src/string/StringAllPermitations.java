package string;

/**
 * Time Complexity: O(n⋅n!) Auxiliary Space: O(n⋅n!)
 * https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
 */
public class StringAllPermitations {
	public static void main(String[] args) {
		String s = "abc";
		printAllPermitations(s, "");
	}

	private static void printAllPermitations(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String substr = str.substring(0, i) + str.substring(i + 1);
			printAllPermitations(substr, ans + ch);
		}
	}
}
