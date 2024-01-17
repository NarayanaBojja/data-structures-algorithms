package ternarysearch;

public class TernarySearchAlgo {

	public static void main(String[] args) {
		int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int index = ternarySearch(ar, 0, 9, 6);
		System.out.println(index);
	}

	private static int ternarySearch(int[] array, int l, int r, int x) {
		while (l <= r) {
			int mid1 = l + (r - l) / 3;
			int mid2 = r - (r - l) / 3;
			if (array[mid1] == x) {
				return mid1;
			}
			if (array[mid2] == x) {
				return mid2;
			}
			if (x < array[mid1]) {
				r = mid1 - 1;
			} else if (x > array[mid2]) {
				l = mid2 + 1;
			} else {
				l = mid1 + 1;
				r = mid2 - 1;
			}
		}
		return -1;
	}
}
