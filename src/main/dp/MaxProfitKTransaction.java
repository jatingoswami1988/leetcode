package main.dp;

public class MaxProfitKTransaction {

	public static void main(String[] args) {

		// int prices[] = { 9, 6, 7, 6, 3, 8 };
		int prices[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int k = 2;
		int result = maxProfitKTransaction(prices, k);
		System.out.println(result);

	}

	private static int maxProfitKTransaction(int[] prices, int k) {
		int dp[][] = new int[k + 1][prices.length];

		//for (int i = 0; i < prices.length; i++) {
		//	dp[0][i] = 0;
		//}

		//for (int i = 0; i <= k; i++) {
		//	dp[i][0] = 0;
		//}

		for (int transactions = 1; transactions <= k; transactions++) {
			for (int days = 1; days < prices.length; days++) {
				int prev = dp[transactions][days - 1];
				int min = 0;
				for (int previousDays = days - 1; previousDays >= 0; previousDays--) {
					prev = Math.max(prev, (prices[days] - prices[previousDays]) + dp[transactions - 1][days - 1]);
					min = Math.max(prev, min);
				}
				dp[transactions][days] = min;
			}
		}

		return dp[k][prices.length - 1];
	}

}
