package array;

/**
 * Sliding Window Technique To find the maximum sum of all sub arrays of size K
 * Time Complexity: O(n) Auxiliary Space: O(1)
 */
public class MaxSumSubArrayOfSize {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 7, 5 };
		int size = 3;
		System.out.println(maxSumSubArrayOfSize(nums, size));
	}

	static int maxSumSubArrayOfSize(int[] nums, int size) {
		if (nums.length < size) {
			return 0;
		}
		int maxSum = 0;
		for (int i = 0; i < size; i++) {
			maxSum += nums[i];
		}
		int windowSum = maxSum;
		for (int i = size; i < nums.length; i++) {
			windowSum += nums[i] - nums[i - size];
			maxSum = Math.max(windowSum, maxSum);
		}
		return maxSum;
	}
}
