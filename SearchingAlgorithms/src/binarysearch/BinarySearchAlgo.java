package binarysearch;

public class BinarySearchAlgo {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 40;
		int index = binarySearchIterative(arr, x);
		if (index != -1) {
			System.out.println(x + " is found at index: " + index + " using Iterative approach");
		} else {
			System.out.println(x + " is not found in an array using Iterative approach");
		}
		int recursiveIndex = binarySearchRecursive(arr, 0, arr.length, x);
		if (recursiveIndex != -1) {
			System.out.println(x + " is found at index: " + recursiveIndex + " using recursive approach");
		} else {
			System.out.println(x + " is not found in an array using recursive approach");
		}
	}

	private static int binarySearchIterative(int array[], int x) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == x) {
				return mid;
			}
			if (array[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	private static int binarySearchRecursive(int array[], int left, int right, int x) {
		if (right >= left) {
			int mid = (left + right) / 2;
			if (array[mid] == x) {
				return mid;
			}
			if (array[mid] < x) {
				return binarySearchRecursive(array, mid + 1, right, x);
			} else {
				return binarySearchRecursive(array, left, mid + 1, x);
			}
		}
		return -1;
	}
}
