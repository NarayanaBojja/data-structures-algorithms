package array;

/**
 * For a given 2D square matrix of size N*N, the task is to find the sum of
 * elements in the Principal and Secondary diagonals Time complexity: O(N) Space
 * complexity: O(1)
 */
public class SumOfDiagonalsArray {

	public static void main(String[] args) {
		int[][] array = { { 8, 2, 13, 4 }, { 9, 16, 17, 8 }, { 1, 22, 3, 14 }, { 15, 6, 17, 8 } };
		System.out.println(sumOfDiagonalsArray(array));
	}

	public static int sumOfDiagonalsArray(int[][] array) {
		int primaryDiagonal = 0;
		int secondaryDiagonal = 0;
		int length = array[0].length;
		for (int i = 0; i < length; i++) {
			primaryDiagonal += array[i][i];
			secondaryDiagonal += array[i][length - (i + 1)];
		}
		return primaryDiagonal + secondaryDiagonal;
	}

}
