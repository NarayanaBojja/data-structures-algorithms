package array;

import java.util.HashMap;
import java.util.Map;
/**
 * Find two numbers that add up to a specific target.
 * https://leetcode.com/problems/two-sum/description/
 *  Time Complexity:O(n) Space Complexity: O(n)
 * 
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		if (nums.length >= 2) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int temp = target - nums[i];
				if (map.containsKey(temp)) {
					System.out.println(i + " " + map.get(temp));
					return;
				} else {
					map.put(nums[i], i);
				}
			}
		}
	}

}
