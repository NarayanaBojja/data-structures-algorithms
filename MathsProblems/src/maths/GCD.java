package maths;

/**
 * Euclid's algorithm
 * Time Complexity: O(log(min(num1, num2))) and Space Complexity:
 * O(log(min(num1, num2)))
 * 
 */
public class GCD {

	public static void main(String[] args) {
		System.out.println(gcd(6, 4));
	}

	static int gcd(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		}
		return gcd(num2, num1 % num2);
	}
}
