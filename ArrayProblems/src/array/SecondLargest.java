package array;

/**
 * Time complexity of O(n) Space complexity O(1)
 */
public class SecondLargest {

	public static void main(String[] args) {
		int arr[] = { 10, 5, 2, 3, 13 };
		System.out.println(print2largest(arr));
		System.out.println("Minimum value: " + minValue(arr));
		System.out.println("Max value: " + maxValue(arr));
	}

	static int print2largest(int arr[]) {
		if (arr == null || arr.length < 2) {
			return -1;
		}
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > largest) {
				secondLargest = largest;
				largest = i;
			} else if (i > secondLargest && i != largest) {
				secondLargest = i;
			}
		}
		if (secondLargest == Integer.MIN_VALUE) {
			return -1;
		}
		return secondLargest;
	}

	static int minValue(int arr[]) {
		int min = Integer.MAX_VALUE;
		for (int i : arr) {
			min = Math.min(i, min);
		}
		return min;
	}
	static int maxValue(int arr[]) {
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = Math.max(i, max);
		}
		return max;
	}
}
