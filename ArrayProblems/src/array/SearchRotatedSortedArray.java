package array;

/**
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k Given the array nums after the possible rotation and an
 * integer target, return the index of target if it is in nums, or -1 if it is
 * not in nums
 */
public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(search(nums, 0));
	}

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}
