package string;

public class StringPermutations {

	public static void main(String[] args) {
		String str = "ABC";
		StringPermutations permutation = new StringPermutations();
		permutation.permute(str, "");
	}

	private void permute(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			permute(ros, ans + ch);
		}
	}

}
