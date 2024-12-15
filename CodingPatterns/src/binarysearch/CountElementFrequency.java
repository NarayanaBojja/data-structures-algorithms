package binarysearch;

/**
 * #binaryseach algorithm Given a sorted array, arr[] and a number target, you
 * need to find the number of occurrences of target in arr[]. O(logn) Time and
 * O(1) Space
 */
public class CountElementFrequency {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 2, 2, 3 };
		System.out.println(countFreq(arr, 2));
	}

	static int countFreq(int[] arr, int target) {
		return upperBound(arr, target) - lowerBound(arr, target);
	}

	static int upperBound(int[] arr, int target) {
		int res = arr.length;
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > target) {
				res = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return res;
	}

	static int lowerBound(int[] arr, int target) {
		int res = arr.length;
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] >= target) {
				res = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return res;
	}
}
