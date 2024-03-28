package array;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] array = { 2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = array[0];
		int sum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (sum >= 0) {
				sum += array[i];
			} else {
				sum = array[i];
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		System.out.println("Sub array Max sum " + maxSum);
	}

}
