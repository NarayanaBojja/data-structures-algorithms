package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all subsequences of an array whose sum equals to K using recursion Time
 * Complexity: O(2^n) Space Complexity: O(n)
 */
public class SubsequencesWithSumK {

	// Helper function to find subsequences recursively
	public static void findSubsequences(int index, int[] arr, List<Integer> current, int sum, int K) {
		// Base case: if we've reached the end of the array
		if (index == arr.length) {
			if (sum == K) {
				System.out.println(current); // print or store the subsequence
			}
			return;
		}

		// Include the current element in the subsequence
		current.add(arr[index]);
		findSubsequences(index + 1, arr, current, sum + arr[index], K);

		// Backtrack and remove the current element from the subsequence
		current.remove(current.size() - 1);

		// Exclude the current element from the subsequence
		findSubsequences(index + 1, arr, current, sum, K);
	}

	// Wrapper function to initiate the recursive process
	public static void findAllSubsequencesWithSumK(int[] arr, int K) {
		List<Integer> current = new ArrayList<>();
		findSubsequences(0, arr, current, 0, K);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1 };
		int K = 2;

		// Find and print all subsequences with sum equals to K
		findAllSubsequencesWithSumK(arr, K);
	}
}