package string;

/**
 * **Time Complexity**: O(max(n, m)) Space Complexity**: O(max(n, m))
 * https://leetcode.com/problems/add-strings/description/
 */
public class AddStrings {

	public static void main(String[] args) {
		String num1 = "18";
		String num2 = "123";
		String result = addStrings(num1, num2);
		System.out.println(result);
	}

	public static String addStrings(String num1, String num2) {
		StringBuilder result = new StringBuilder();
		int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += num1.charAt(i--) - '0';
			if (j >= 0)
				sum += num2.charAt(j--) - '0';
			result.append(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0)
			result.append(carry);
		return result.reverse().toString();
	}
}
