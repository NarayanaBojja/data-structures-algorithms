package array;

/**
 * Time complexity O(n) Space complexity O(1)
 */
public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = { 5, 8, 7, 6 };
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

}
