package binarysearch;

/**
 * A sorted array of distinct elements arr[] is rotated at some unknown point,
 * the task is to find the minimum element in it. Time O(logn)  and O(1) Space
 */
public class MinimumInSortedAndRotatedArray {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 1, 2, 3, 4 };
		System.out.println("Minimum: " + findMin(arr));
	}

	public static int findMin(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo < hi) {
			if (arr[lo] < arr[hi]) {
				return arr[lo];
			}
			int mid = (lo + hi) / 2;
			if (arr[mid] > arr[hi]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return arr[lo];
	}
}
