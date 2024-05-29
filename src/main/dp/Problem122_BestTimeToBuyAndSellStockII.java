package main.dp;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/3003423/java-solution-three-approach-sliding-window-memoization-tabulation-space-optimise/
public class Problem122_BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {

		//int prices[] = { 7, 1, 5, 3, 6, 4 };
		int prices[] = { 4,6 };
		//System.out.println(recursion(prices, 0, 0));
		System.out.println(tabulation1(prices));
	}
	
	public static int tabulation1(int[] prices) {
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
		return dp[0][1][2];// depth/Row/col
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

	// if i decide to buy at 7 and sell at 5 so net profit will be Profit = (5-7) == So i am adding -7 to the profit when buy and +5 in profit while selling
	// i always want max profit
	private static long recursion(int[] prices, int index, int buy) {

		if (index == prices.length) {
			return 0;
		}

		long profit = 0;

		if (buy == 0) {
					// Take                                                       // Dont take 
			profit = Math.max(-prices[index] + recursion(prices, index + 1, 1), 0 + recursion(prices, index + 1, 0));

		} else {
			        // Take                                                       // Dont take 
			profit = Math.max(prices[index] + recursion(prices, index + 1, 0), 0 + recursion(prices, index + 1, 1));
		}

		return profit;
	}

}
