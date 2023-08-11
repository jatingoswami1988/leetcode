package main.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/3003423/java-solution-three-approach-sliding-window-memoization-tabulation-space-optimise/
public class Problem122_BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {

		int prices[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println(recursion(prices, 0, 0));
		System.out.println(tabulation(prices));
	}

	private static int tabulation(int[] prices) {
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
					profit = Math.max(prices[index] + dp[index + 1][0], 0 + dp[index + 1][1]);
				}
				dp[index][buy] = profit;
			}
		}

		return dp[0][0];
	}

	private static long recursion(int[] prices, int index, int buy) {

		if (index == prices.length) {
			return 0;
		}

		long profit = 0;

		if (buy == 0) {

			profit = Math.max(-prices[index] + recursion(prices, index + 1, 1), 0 + recursion(prices, index + 1, 0));

		} else {

			profit = Math.max(prices[index] + recursion(prices, index + 1, 0), 0 + recursion(prices, index + 1, 1));
		}

		return profit;
	}

}
