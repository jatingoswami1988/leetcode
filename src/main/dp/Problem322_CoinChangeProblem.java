package main.dp;

import java.util.Arrays;

//// https://leetcode.com/problems/coin-change/solutions/3839103/recursive-approach-recursion-with-memoization-top-down-tabulation-method-bottom-up/

public class Problem322_CoinChangeProblem {

	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 }, amount = 11;
		int[] dp = new int[amount + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {

				if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}
		
		System.out.println((dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount]);

	}

}
