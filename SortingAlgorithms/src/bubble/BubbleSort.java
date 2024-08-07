package bubble;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 * swapping the adjacent elements if they are in the wrong order. This algorithm
 * is not suitable for large data sets as its average and worst-case time
 * complexity is quite high. Time Complexity: O(n2) Space Complexity: O(1)
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 5, 1, 7, 2, 3, 9 };
		bubbleSort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}

	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean swap = false;
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}
}
