package array;

public class SortZerosOnes {

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		int zerosCount = 0;
		int oneCount = 0;
		int twoCount = 0;
		for (int i : nums) {
			switch (i) {
			case 0:
				zerosCount++;
				break;
			case 1:
				oneCount++;
				break;
			case 2:
				twoCount++;
			}
		}
		int i = 0;
		if (zerosCount > 0) {
			for (; i < zerosCount; i++) {
				nums[i] = 0;
			}
		}
		if (oneCount > 0) {
			int maxIndexOne = i + oneCount;
			for (; i < maxIndexOne; i++) {
				nums[i] = 1;
			}
		}
		if (twoCount > 0) {
			int maxIndexTwo = i + twoCount;
			for (; i < maxIndexTwo; i++) {
				nums[i] = 2;
			}
		}
		for (int x : nums) {
			System.out.print(x + " ");
		}
	}

}
