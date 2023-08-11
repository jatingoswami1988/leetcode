package main.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/solutions/2148232/well-explained-with-4-different-approaches-easy/
public class Porblem123_BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {
		int prices[] = { 7, 6, 4, 3, 1 };
		int txn = 2;
		System.out.println(recursion(prices, 0, 0, txn));
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

		// for (int index = n - 1; index >= 0; index--) {
		// for (int buy = 0; buy <= 1; buy++) {
		// for (int txn = 1; txn <= 2; txn++) {
		// if (buy == 0) {// We can buy the stock
		// dp[index][buy][txn] = Math.max(-prices[index] + dp[index + 1][1][txn], 0 +
		// dp[index + 1][0][txn]);
		// } else {
		// // if (buy == 1) {// We can sell the stock
		// dp[index][buy][txn] = Math.max(prices[index] + dp[index + 1][0][txn], 0 +
		// dp[index + 1][1][txn]);
		// }
		// //dp[index][buy][txn] = profit;
		// }
		// // dp[index][buy] = profit;
		// }
		// }

		// return dp[0][1][2];
	}

	private static long recursion(int[] prices, int index, int buy, int txn) {

		if (index == prices.length || txn == 0) {
			return 0;
		}

		long profit = 0;

		if (buy == 0) {

			profit = Math.max(-prices[index] + recursion(prices, index + 1, 1, txn),
					0 + recursion(prices, index + 1, 0, txn));

		} else {

			profit = Math.max(prices[index] + recursion(prices, index + 1, 0, txn - 1),
					0 + recursion(prices, index + 1, 1, txn));
		}

		return profit;
	}

}
