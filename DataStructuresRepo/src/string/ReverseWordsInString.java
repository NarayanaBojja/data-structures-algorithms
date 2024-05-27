package string;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String str = "i.like.this.program.very.much";
		String reverseWord = reverseWord(str);
		System.out.println(reverseWord);
	}

	private static String reverseWord(String str) {
		String[] strArray = str.split("\\.");
		for (int i = 0; i < strArray.length / 2; i++) {
			String temp = strArray[i];
			strArray[i] = strArray[strArray.length - 1 - i];
			strArray[strArray.length - 1 - i] = temp;

		}
		return String.join(".", strArray);
	}

}
