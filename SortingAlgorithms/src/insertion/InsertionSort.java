package insertion;

/**
 * Insertion sort is a simple sorting algorithm that works by iteratively
 * inserting each element of an unsorted list into its correct position in a
 * sorted portion of the list. It is a stable sorting algorithm, meaning that
 * elements with equal values maintain their relative order in the sorted
 * output.
 * Time Complexity: O(n2) Space Complexity: O(1)
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] array = { 5, 1, 7, 2, 3, 9 };
		insertionSort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
}
