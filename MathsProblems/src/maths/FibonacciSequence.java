package maths;

public class FibonacciSequence {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(fibonacciSequenceSum(n));

	}

	private static int fibonacciSequenceSum(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		int[] array = new int[n];
		array[0] = 0;
		array[1] = 1;

		for (int i = 2; i < n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[array.length - 1] + array[array.length - 2];
	}
}
