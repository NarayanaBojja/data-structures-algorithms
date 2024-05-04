package slidingwindow;

/**
 * time complexity of the algorithm is O(N), and the space complexity is
 * O(N-K+1)
 */
public class FindAverages {

	public static double[] findAverages(int[] array, int k) {
		double[] results = new double[array.length - k + 1];
		int windowStart = 0;
		int windowSum = 0;
		for (int i = 0; i < array.length; i++) {
			windowSum += array[i];
			if (i >= k - 1) {
				results[windowStart] = windowSum / k;
				windowSum -= array[windowStart];
				windowStart++;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		int K = 3;
		double[] result = findAverages(arr, K);
		System.out.println("Averages of subarrays of size " + K + ":");
		for (double avg : result) {
			System.out.print(avg + " ");
		}

	}

}
