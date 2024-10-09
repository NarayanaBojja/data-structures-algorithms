package recursion;

/**
 * counts all subsequences of an array whose sum matches a given target value
 * Time Complexity: 𝑂(2𝑛) Space Complexity: O(n) 
 */
public class SubsequenceCount {

	static int subSequenceCount(int[] arr, int sum, int index, int currentSum) {
		if (index == arr.length) {
			return sum == currentSum ? 1 : 0;

		}
		int left = subSequenceCount(arr, sum, index + 1, currentSum + arr[index]);
		int right = subSequenceCount(arr, sum, index + 1, currentSum);
		return left + right;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 5, 4 };
		int target = 6;

		int totalSubsequences = subSequenceCount(arr, target, 0, 0);
		System.out.println("Total subsequences with sum " + target + ": " + totalSubsequences);
	}
}
