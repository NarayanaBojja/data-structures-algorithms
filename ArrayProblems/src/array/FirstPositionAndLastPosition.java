package array;

public class FirstPositionAndLastPosition {

	public static void main(String[] args) {
		FirstPositionAndLastPosition fl = new FirstPositionAndLastPosition();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] arr = fl.searchRange(nums, 8);
		System.out.println(arr[0] + " " + arr[1]);
	}

	public int[] searchRange(int[] nums, int target) {
		int first = getFirstPos(nums, target);
		int last = getLastPos(nums, target);
		return new int[] { first, last };
	}

	int getFirstPos(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int res = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				res = mid;
				right = mid - 1;
			}
		}
		return res;
	}

	int getLastPos(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int res = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				res = mid;
				left = mid + 1;
			}
		}
		return res;
	}
}
