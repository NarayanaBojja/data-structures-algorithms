package array;

/**
 * Given a non-empty array of integers arr, every element appears twice except
 * for one. Find that single one.Time Complexity: O(N), Space Complexity: O(1)
 */
public class FindNumberAppearOnce {

	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 1, 2 };
		int ans = getSingleElement(arr);
		System.out.println("The single element is: " + ans);

	}

	public static int getSingleElement(int[] arr) {
		// size of the array:
		int n = arr.length;

		// XOR all the elements:
		int xorr = 0;
		for (int i = 0; i < n; i++) {
			xorr = xorr ^ arr[i];
		}
		return xorr;
	}
}
