package main.dp;

public class KnapsackProblem {

	public static void main(String args[]) {
		int profit[] = new int[] { 60, 100, 120 };
		int weight[] = new int[] { 1, 2, 3 };
		int W = 5;
		int n = profit.length;
		System.out.println(knapSack(W, weight, profit, n));
		System.out.println(knapSackTabulationOptimised(W, weight, profit, n));
	}

	public static int knapSack(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0) {
			return 0;
		} else if (wt[n - 1] > W) {
			return knapSack(W, wt, val, n - 1);
		} else {
			return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
		}
	}

	public static int knapSackTabulationOptimised(int W, int wt[], int val[], int n) {
		int[] dp = new int[W + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int w = W; w >= 0; w--) {

				if (wt[i - 1] <= w)

					// Finding the maximum value
					dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + val[i - 1]);
			}
		}
		// Returning the maximum value of knapsack
		return dp[W];
	}

}
