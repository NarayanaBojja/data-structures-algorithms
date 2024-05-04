package slidingwindow;

/**
 * time complexity of the algorithm is O(N), and the space complexity is O(1)
 */
public class MinSubArrayLength {

	public static int minSubArrayLen(int target, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int windowStart = 0;
		int windowSum = 0;
		for (int i = 0; i < nums.length; i++) {
			windowSum += nums[i];
			while (windowSum >= target) {
				minLength = Math.min(minLength, i - windowStart + 1);
				windowSum -= nums[windowStart];
				windowStart++;
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 11;
		int minLen = minSubArrayLen(k, arr);
		System.out.println("Min subarray size " + minLen);

	}

}
