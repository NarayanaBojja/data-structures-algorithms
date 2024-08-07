package array;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array. Time Complexity:
 * O(n), Space Complexity: O(1)
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		System.out.println(missingNumber(nums));
	}

	public static int missingNumber(int[] nums) {
		int sum = 0;
		for (int element : nums) {
			sum += element;
		}
		int totalNumbers = nums.length;
		int sumOfAllNumbers = (totalNumbers * (totalNumbers + 1)) / 2;
		return sumOfAllNumbers - sum;

	}
}
