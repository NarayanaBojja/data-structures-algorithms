package maths;

/**
 * Number is palindrome if it is same after reversing it also
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		int number = 121;

		int reverse = 0;
		int temp = number;
		while (temp != 0) {
			reverse = (reverse * 10) + (temp % 10);
			temp /= 10;
		}
		System.out.println("Reverse number : " + reverse);
		System.out.println(number == reverse ? "Palindrome" : "Not Palindrome");
	}

}
