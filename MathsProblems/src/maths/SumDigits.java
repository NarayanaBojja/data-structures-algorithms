package maths;

public class SumDigits {

	public static void main(String[] args) {
		System.out.println(sumDigitsUsingRecursion(752));
		System.out.println(sumDigitsUsingIterative(752));

	}

	/**
	 * Time complexity: O(d) Auxiliary Space: O(d), d - no.of digits
	 */
	public static int sumDigitsUsingRecursion(int number) {
		if (number == 0) {
			return 0;
		}
		return number % 10 + sumDigitsUsingRecursion(number / 10);

	}
	/**
	 * Time complexity: O(d) Auxiliary Space: O(1), d - no.of digits
	 */
	public static int sumDigitsUsingIterative(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number = number / 10;
		}
		return sum;

	}
}
