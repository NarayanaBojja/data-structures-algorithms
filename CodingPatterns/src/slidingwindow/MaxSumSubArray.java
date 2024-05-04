package slidingwindow;

/**
 * time complexity of the algorithm is O(N), and the space complexity is O(1)
 */
public class MaxSumSubArray {

	public static int findMaxSumSubarray(int[] array, int k) {
		int maxSum = 0;
		int windowSum = 0;
		int windowStart = 0;
		for (int i = 0; i < array.length; i++) {
			windowSum += array[i];
			if (i >= k - 1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= array[windowStart];
				windowStart++;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 };
		int k = 3;
		int maxSum = findMaxSumSubarray(arr, k);
		System.out.println("Maximum sum of subarray of size " + k + ": " + maxSum);

	}

}
