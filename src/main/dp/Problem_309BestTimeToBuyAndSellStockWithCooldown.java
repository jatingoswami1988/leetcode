package main.dp;

public class Problem_309BestTimeToBuyAndSellStockWithCooldown {

	public static void main(String[] args) {
		int prices[] = { 1,2,3,0,2 };
		System.out.println(recursion(prices, 0, 0));
		System.out.println(tabulation(prices));

	}
	
	private static int tabulation(int[] prices) {
		int n = prices.length;
		int dp[][] = new int[n + 2][2];
		// base condition
		int profit = 0;

		for (int index = n - 1; index >= 0; index--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 0) {// We can buy the stock
					dp[index][buy] = Math.max(-prices[index] + dp[index + 1][1], 0 + dp[index + 1][0]);
				} else {
					// if (buy == 1) {// We can sell the stock
					dp[index][buy] = Math.max(prices[index] + dp[index + 2][0], 0 + dp[index + 1][1]);
				}
			}
		}

		return dp[0][0];
	}

	private static int recursion(int[] prices, int index, int buy) {
		if (index >= prices.length) {
			return 0;
		}

		int profit = 0;
		
		// buy = 0
		// sell = 1
		
		if (buy==0) {

			profit = Math.max(-prices[index] + recursion(prices, index + 1, 1), 0 + recursion(prices, index + 1, 0));

		} else {

			profit = Math.max(prices[index] + recursion(prices, index + 2, 0), 0 + recursion(prices, index + 1, 1));
		}

		return profit;
	}

}
