package array;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2, 2 };
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				System.out.println(num);
			}
			set.add(num);
		}
	}

}
