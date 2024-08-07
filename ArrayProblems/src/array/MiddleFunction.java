package array;

/**
 * Write a function called middle that takes an array and returns a new array
 * that contains all but the first and last elements.
 * Time complexity: O(n), Space complexity: O(n)
 */
public class MiddleFunction {

	public static void main(String[] args) {

	}

	public static int[] middle(int[] array) {
		int[] newArray = new int[array.length - 2];
		for (int i = 1; i < array.length - 1; i++) {
			newArray[i - 1] = array[i];
		}
		return newArray;
	}
}
