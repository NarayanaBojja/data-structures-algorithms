package array;

import java.util.PriorityQueue;

/**
 * Time Complexity: O(N * log(K)) Auxiliary Space: O(K)
 */
public class KthLargestElement {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		System.out.println("Second largest element: " + findKthLargest(nums, 2));

	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			pq.offer(nums[i]);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
}
