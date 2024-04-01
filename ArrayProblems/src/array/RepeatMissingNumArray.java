package array;

import java.util.Arrays;

/**
 * Time complexity O(n log(n)) Space complexity O(1)
 */
public class RepeatMissingNumArray {

	public static void main(String[] args) {
		int[] array = { 3, 1, 2, 5, 3 };

		Arrays.sort(array);
		int repeatingNum = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == array[i + 1]) {
				repeatingNum = array[i];
				break;
			}
		}
		int missingNum = 0;
		for (int i = 0; i < array.length; i++) {
			if ((array[i + 1] - array[i]) > 1) {
				missingNum = array[i] + 1;
				break;
			}
		}
		System.out.println("Missing num " + missingNum);
		System.out.println("Repeating num " + repeatingNum);
	}
}
