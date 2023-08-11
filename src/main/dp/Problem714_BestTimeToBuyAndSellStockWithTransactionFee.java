package main.dp;

public class Problem714_BestTimeToBuyAndSellStockWithTransactionFee {

	public static void main(String[] args) {
		int prices[] = {1,3,7,5,10,3 };
		int fee = 3;
		System.out.println(recursion(prices, 0, 0, fee));
		System.out.println(tabulation(prices, fee));

	}

	private static int tabulation(int[] prices, int fee) {
		int n = prices.length;
		int dp[][] = new int[n + 1][2];
		// base condition
		int profit = 0;

		for (int index = n - 1; index >= 0; index--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 0) {// We can buy the stock
					profit = Math.max(-prices[index] + dp[index + 1][1], 0 + dp[index + 1][0]);
				} else {
					// if (buy == 1) {// We can sell the stock
					profit = Math.max(prices[index] + dp[index + 1][0] - fee, 0 + dp[index + 1][1]);
				}
				dp[index][buy] = profit;
			}
		}

		return dp[0][0];
	}

	private static long recursion(int[] prices, int index, int buy, int fee) {

		if (index == prices.length) {
			return 0;
		}

		long profit = 0;

		if (buy == 0) {

			profit = Math.max(-prices[index] + recursion(prices, index + 1, 1, fee),
					0 + recursion(prices, index + 1, 0, fee));

		} else {

			profit = Math.max(prices[index] + recursion(prices, index + 1, 0, fee) - fee,
					0 + recursion(prices, index + 1, 1, fee));
		}

		return profit;
	}

}
