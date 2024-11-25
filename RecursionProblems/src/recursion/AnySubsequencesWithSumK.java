package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * any subsequence of an array whose sum matches a given target value, using
 * recursion. Time Complexity: O(2^n) Space Complexity: O(n)
 */

public class AnySubsequencesWithSumK {

	// Function to find and print any subsequence whose sum matches the target
	public static boolean findSubsequence(int[] arr, int target, int index, List<Integer> currentSubsequence) {
		// Base case: if index reaches the end
		if (index == arr.length) {
			int sum = 0;
			for (int num : currentSubsequence) {
				sum += num;
			}
			// If sum matches the target, print the subsequence
			if (sum == target) {
				System.out.println("Subsequence: " + currentSubsequence);
				return true; // Return true to indicate a subsequence is found
			}
			return false;
		}

		// Include the current element in the subsequence
		currentSubsequence.add(arr[index]);
		if (findSubsequence(arr, target, index + 1, currentSubsequence)) {
			return true; // If a subsequence is found, stop further recursion
		}

		// Backtrack and exclude the current element from the subsequence
		currentSubsequence.remove(currentSubsequence.size() - 1);
		if (findSubsequence(arr, target, index + 1, currentSubsequence)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		
		int[] arr = { 3, 1, 2, 5, 4 };
		int target = 6;
		List<Integer> subsequence = new ArrayList<>();

		if (!findSubsequence(arr, target, 0, subsequence)) {
			System.out.println("No subsequence found with the given sum.");
		}
	}
}
