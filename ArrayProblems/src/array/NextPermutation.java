package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/description/
 * 
 * Time complexity: O(n) Space complexity: O(1)
 */
public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}
		// Find the first decreasing element from the right.
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		// If no decreasing element is found, reverse the array.
		if (i < 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		// Find the smallest element greater than nums[i] from the right.
		int j = nums.length - 1;
		while (j >= 0 && nums[j] <= nums[i]) {
			j--;
		}
		// Swap nums[i] and nums[j].
		swap(nums, i, j);
		// Reverse the subarray from i + 1 to the end.
		reverse(nums, i + 1, nums.length - 1);
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
