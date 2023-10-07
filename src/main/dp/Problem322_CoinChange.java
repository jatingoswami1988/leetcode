package main.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
// https://www.geeksforgeeks.org/coin-change-dp-7/
//
public class Problem322_CoinChange {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 5 };
		int target = 5;
		List<List<Integer>> result = new ArrayList<>();
		problem322CoinChangeBactracking(arr, result, new ArrayList<>(), target, 0); // Combinatory Problem

		// PickAndDontPick logic
		result = new ArrayList<>();
		//System.out.println(pickAndDontPickLogic(arr,arr.length,target));
		//System.out.println(result);
		System.out.println(problem322CoinChangeDPTabulation(arr, target, arr));
		System.out.println(problem322CoinChangeDPTabulationSpaceOpimized(arr, target));

	}
	
	public static int pickAndDontPickLogic1(int coins[], int n, int sum) {

		if (sum == 0) {
			return 1;
		}

		if (sum < 0) {
			return 0;
		}

		if (n <= 0) {
			return 0;
		}

		return pickAndDontPickLogic(coins, n - 1, sum) + pickAndDontPickLogic(coins, n, sum - coins[n - 1]);
	}

	public static int pickAndDontPickLogic(int coins[], int n, int sum) {

		if (sum == 0) {
			return 1;
		}

		if (sum < 0) {
			return 0;
		}

		if (n <= 0) {
			return 0;
		}

		return pickAndDontPickLogic(coins, n - 1, sum) + pickAndDontPickLogic(coins, n, sum - coins[n - 1]);
	}

	private static int problem322CoinChangeDPTabulation(int[] arr, int sum, int[] coins) {
		int dp[][] = new int[arr.length + 1][sum + 1];

		dp[0][0] = 1;

		for (int i = 1; i <= arr.length; i++) { // Coins Row
			for (int j = 0; j <= sum; j++) { // Target Sum Column

				// Dont pick
				dp[i][j] = dp[i][j] + dp[i - 1][j];

				if ((j - coins[i - 1]) >= 0) {
					// Include
					dp[i][j] = dp[i][j] + dp[i][j - coins[i - 1]];
				}
			}
		}
		return dp[arr.length][sum];
	}

	private static int problem322CoinChangeDPTabulationSpaceOpimized(int[] coins, int sum) {
		int[] dp = new int[sum + 1];

		// Initialize all table values as 0
		Arrays.fill(dp, 0);

		// Base case (If given value is 0)
		dp[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= sum; j++) {
				dp[j] = dp[j] + dp[j - coins[i]];
			}
		}

		return dp[sum];
	}

	// BactTracking
	private static void problem322CoinChangeBactracking(int[] arr, List<List<Integer>> result, List<Integer> temp,
			int target, int index) {

		if (target == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = index; i < arr.length; i++) {
			if (target - arr[i] < 0)
				continue;
			temp.add(arr[i]);
			problem322CoinChangeBactracking(arr, result, new ArrayList<>(temp), target - arr[i], index);
			temp.remove(temp.size() - 1);
		}
	}
}
