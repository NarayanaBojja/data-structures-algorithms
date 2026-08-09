package prefix;

import java.util.Arrays;

/**
 * Given an integer array arr of length n and an integer k.
 * 
 * Generate a new array res such that:
 * 
 * If i < k
 * 
 * res[i] = arr[0] + arr[1] + ... + arr[i]
 * 
 * Otherwise
 * 
 * res[i] = arr[i-k+1] + ... + arr[i]
 * 
 * Time complexity: O(n) Space complexity: O(n)
 * 
 */

public class SlidingWindowSum {

	public static int[] calculate(int[] arr, int k) {

		int n = arr.length;
		int[] res = new int[n];

		int windowSum = 0;

		for (int i = 0; i < n; i++) {

			windowSum += arr[i];

			// Remove element outside window
			if (i >= k) {
				windowSum -= arr[i - k];
			}

			res[i] = windowSum;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int k = 3;
		System.out.println(Arrays.toString(calculate(arr, k)));
	}
}
