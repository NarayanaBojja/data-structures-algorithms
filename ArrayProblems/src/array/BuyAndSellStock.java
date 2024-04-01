package array;

public class BuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maximumProfit = 0;
		int minimum = prices[0];
		for (int i = 1; i < prices.length; i++) {
			minimum = Math.min(minimum, prices[i]);
			maximumProfit = Math.max(maximumProfit, prices[i] - minimum);
		}
		System.out.println("Maximum Profit " + maximumProfit);
	}

}
