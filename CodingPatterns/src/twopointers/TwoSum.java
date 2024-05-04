package twopointers;
/**
 * Time complexity: O(n) and Space complexity: O(1)
 * Input array must be sorted
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 5, 9, 11 };
		int target = 11;
		int[] indexes = twoSum(nums, target);
		for (int i : indexes) {
			System.out.print(i + " ");
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int currentSum = nums[start] + nums[end];
			if (currentSum == target) {
				return new int[] { start, end };
			}
			if (currentSum < target) {
				start++;
			} else {
				end--;
			}
		}
		return new int[] { -1 };
	}

}
