package merge;

public class MergeSortAlgo {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		mergeSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	private static void merge(int[] array, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftArr[i] = array[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArr[j] = array[mid + 1 + j];
		}
		int k = left;
		int i = 0;
		int j = 0;
		while (i < n1 && j < n2) {
			if (leftArr[i] <= rightArr[j]) {
				array[k] = leftArr[i];
				i++;

			} else {
				array[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = rightArr[j];
			j++;
			k++;
		}

	}
}
