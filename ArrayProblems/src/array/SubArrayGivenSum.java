package array;

import java.util.ArrayList;

public class SubArrayGivenSum {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4};
		ArrayList<Integer> list = subarraySum(nums, 10, 0);
		System.out.println(list);
	}

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		ArrayList<Integer> list = new ArrayList<>();
		int currentSum = 0;
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			while (currentSum > s) {
				currentSum -= arr[start];
				start++;
			}
			if (currentSum == s) {
				for (int j = start; j <= i; j++) {
					list.add(arr[j]);
				}
				return list;
			}
		}
		return list;
	}

}
