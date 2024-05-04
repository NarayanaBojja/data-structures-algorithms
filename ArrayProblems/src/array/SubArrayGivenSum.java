package array;

import java.util.ArrayList;

public class SubArrayGivenSum {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 7, 5 };
		ArrayList<Integer> list = subarraySum(nums, 12);
		System.out.println(list);
	}

	static ArrayList<Integer> subarraySum(int[] arr, int s) {
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
					list.add(j);
				}
			}
		}
		if (!list.isEmpty()) {
			ArrayList<Integer> finalList = new ArrayList<>();
			finalList.add(list.get(0) + 1);
			finalList.add(list.get(list.size() - 1) + 1);
			return finalList;

		}
		return list;
	}

}
