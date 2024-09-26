package array;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Time complexity: O(log n) Space complexity: O(1)
 */
public class PeakElement {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(findPeakElement(nums));
	}

	public static int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int mid = 0;
		int n = nums.length;
		while (low <= high) {
			mid = (low + high) >> 1;
			if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == n - 1 || nums[mid + 1] <= nums[mid])) {
				break;
			}
			if (mid > 0 && nums[mid - 1] > nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return mid;
	}
}
