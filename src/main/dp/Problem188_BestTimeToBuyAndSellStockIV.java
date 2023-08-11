package main.dp;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/solutions/2557296/2d-dp-java-memoization-tabulation/
public class Problem188_BestTimeToBuyAndSellStockIV {

	public static void main(String[] args) {
		int prices[] = { 7, 6, 4, 3, 1 };
		int txn = 2;
		System.out.println(tabulation(prices));
	}

	private static int tabulation(int[] prices) {
		// otimization after current
		int n = prices.length;
		int dp[][][] = new int[n + 1][2][3];
		// base condition

		for (int index = n - 1; index >= 0; index--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int allowedTransactions = 1; allowedTransactions <= 2; allowedTransactions++) {
					if (buy == 1) {
						dp[index][buy][allowedTransactions] = Math.max(-prices[index] + dp[index + 1][0][allowedTransactions], dp[index + 1][1][allowedTransactions]);
					} else {
						dp[index][buy][allowedTransactions] = Math.max(prices[index] + dp[index + 1][1][allowedTransactions - 1], dp[index + 1][0][allowedTransactions]);
					}
				}
			}
		}
		return dp[0][1][2];
	}
}
