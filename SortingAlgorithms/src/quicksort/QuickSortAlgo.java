package quicksort;

public class QuickSortAlgo {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}
}
