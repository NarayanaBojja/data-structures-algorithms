package twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity: O(n) and Space complexity: O(n)
 */
public class TwoSumUsingHashMap {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] indexes = twoSum(nums, target);
		for (int i : indexes) {
			System.out.print(i + " ");
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				return new int[] { map.get(diff), i };
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
