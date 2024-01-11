package maths;

public class CountDigits {

	public static void main(String[] args) {
		int number = 45789;
		int count = 0;
		while (number > 0) {
			number /= 10;
			count++;
		}
		System.out.println("Digits count: " + count);
	}

}
