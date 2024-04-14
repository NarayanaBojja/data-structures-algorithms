package stack;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElementNaive {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums1) {
			int index = findElementIndex(nums2, num);
			if (index == -1 || index == nums2.length - 1) {
				list.add(-1);
				continue;
			}
			boolean found = false;
			for (int i = index + 1; i < nums2.length; i++) {
				if (nums2[i] > num) {
					list.add(nums2[i]);
					found = true;
					break;
				}
			}
			if (!found) {
				list.add(-1);
			}
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	public static int findElementIndex(int[] nums2, int element) {
		int index = -1;
		for (int i = 0; i < nums2.length; i++) {
			if (nums2[i] == element) {
				return i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums1 = { 2, 4 };
		int[] nums2 = { 1, 2, 3, 4 };
		int[] array = nextGreaterElement(nums1, nums2);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}
