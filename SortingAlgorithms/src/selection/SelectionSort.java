package selection;

/**
 * Selection sort is a simple and efficient sorting algorithm that works by
 * repeatedly selecting the smallest (or largest) element from the unsorted
 * portion of the list and moving it to the sorted portion of the list. Time
 * Complexity: O(N2) Space Complexity: O(1)
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] array = { 5, 1, 7, 2, 3, 9 };
		selectionSort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
}
