package bubble;

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
			for (int j = 0; j < array.length - i - 1; j++) {
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
