package recursion;

/**
 * Factorial of a non-negative integer, is multiplication of all integers
 * smaller than or equal to n. 
 * Time Complexity: O(n) Auxiliary Space: O(n)
 */
public class Factorial {

	public static void main(String[] args) {

		int num = 5;
		System.out.println("Factorial of " + num + " is " + factorial(5));

	}

	static int factorial(int n) {
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

}
