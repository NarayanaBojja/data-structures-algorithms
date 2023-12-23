package linearsearch;

public class LinearSearchAlgo {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 100;
		int index = linearSearch(arr, x);
		if (index != -1) {
			System.out.println(x + " is found at index: " + index);
		} else {
			System.out.println(x + " is not found in an array");
		}
	}

	private static int linearSearch(int[] array, int element) {
		if (array.length == 0) {
			return -1;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}
}
