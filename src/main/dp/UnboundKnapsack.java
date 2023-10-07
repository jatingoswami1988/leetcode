package main.dp;

public class UnboundKnapsack {

	public static void main(String[] args) {

		int W = 100;
		int val[] = { 10, 30, 20 };
		int wt[] = { 5, 10, 15 };
		int n = val.length;
		System.out.println(unboundedKnapsack(W, wt, val, n - 1));

	}

	public static int unboundedKnapsack(int W, int wt[], int val[], int n) {
		if (n == 0) {
			return (W / wt[0]) * val[0];
		}
		int notTake = 0 + unboundedKnapsack(W, wt, val, n - 1);
		int take = Integer.MIN_VALUE;
		if (wt[n] <= W) {
			take = val[n] + unboundedKnapsack(W - wt[n], wt, val, n);
		}
		return Math.max(take, notTake);
	}

	private static int unboundedKnapsack(int W, int n, int[] val, int[] wt) {
		int dp[] = new int[W + 1];
		for (int i = 0; i <= W; i++) {
			for (int j = 0; j < n; j++) {
				if (wt[j] <= i) {
					dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
				}
			}
		}
		return dp[W];
	}

}
