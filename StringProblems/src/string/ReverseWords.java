package string;

public class ReverseWords {

	public static void main(String[] args) {
		String s = "  Bob    Loves  Alice   ";
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		s = s.trim();
		String tempStr = "";
		for (String str : s.split(" ")) {
			if (str.trim().equals("")) {
				continue;
			}
			tempStr = tempStr + str + " ";
		}
		tempStr = tempStr.trim();
		String[] strArray = tempStr.split(" ");
		for (int i = 0; i < strArray.length / 2; i++) {
			String temp = strArray[i].trim();
			strArray[i] = strArray[strArray.length - 1 - i].trim();
			strArray[strArray.length - 1 - i] = temp;
		}
		return String.join(" ", strArray);
	}
}
