package array;

import java.util.Arrays;

/**
 * Given two arrays of integers, compute the pair of values (one value in each
 * array) with the smallest (non-negative) difference. Return the difference.
 * Input : A[] = {1, 3, 15, 11, 2} B[] = {23, 127, 235, 19, 8} Output : 3 This
 * algorithm takes O(m log m + n log n) time to sort and O(m + n) time to find
 * the minimum difference. Therefore, the overall runtime is O(m log m + n log
 * n). Auxiliary Space: O(1)
 */
public class SmallDiffArrayValues {

	public static void main(String[] args) {
		
		int a[] = { 1, 2, 11, 5 };
		int b[] = { 4, 12, 19, 23, 127, 235 };
		
		Arrays.sort(a);
        Arrays.sort(b);
        
		int i = 0;
		int j = 0;
		int result = Integer.MAX_VALUE;
		while (i < a.length && j < b.length) {
			result = Math.abs(a[i] - b[j]);
			if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		
		System.out.println("Minimum difference " + result);
	}

}
