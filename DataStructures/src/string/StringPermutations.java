package string;

public class StringPermutations {

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		StringPermutations permutation = new StringPermutations();
		permutation.permute(str, 0, n - 1);
	}

	private void permute(String str, int l, int r) {
		System.out.println(str + " " + l + " " + r);
		if (l == r) {
			//System.out.println(str);		
		}
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				System.out.println("first: "+str);
				permute(str, l + 1, r);
				str = swap(str, l, i);
				System.out.println("second: "+str);
			}
		}
	}

	private String swap(String s, int i, int j) {
		char[] charArray = s.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
