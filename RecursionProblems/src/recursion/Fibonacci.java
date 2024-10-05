package recursion;

/**
 * Time complexity: O(2^n) space complexity is O(n)
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(NthFibonacci(6));
	}

	static int NthFibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return NthFibonacci(n - 1) + NthFibonacci(n - 2);
	}
}
