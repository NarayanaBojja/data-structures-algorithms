package array;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };

		int m = 3;
		for (int i = 0; i < nums2.length; i++) {
			nums1[m + i] = nums2[i];
		}
		Arrays.sort(nums1);
		for (int i : nums1) {
			System.out.print(i + " ");
		}
	}

}
