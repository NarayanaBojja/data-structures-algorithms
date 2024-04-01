package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/ 
 * Time Complexity:O(n log n) Space Complexity: O(n)
 */
public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		intervals = merge(intervals);
		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals[i].length; j++) {
				System.out.print(intervals[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int intervalStart = intervals[0][0];
		int intervalEnd = intervals[0][1];
		List<int[]> mergedList = new ArrayList<>();

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] > intervalEnd) {
				mergedList.add(new int[] { intervalStart, intervalEnd });
				intervalStart = intervals[i][0];
				intervalEnd = intervals[i][1];
			} else {
				intervalEnd = Math.max(intervalEnd, intervals[i][1]);
			}
		}
		mergedList.add(new int[] { intervalStart, intervalEnd });
		return mergedList.toArray(new int[mergedList.size()][]);
	}
}
