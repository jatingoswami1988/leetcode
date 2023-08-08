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

		int arr[] = { 1, 2, 5};
		int target = 5;
		List<List<Integer>> result = new ArrayList<>();
		problem322CoinChangeBactracking(arr, result, new ArrayList<>(), target, 0);
		System.out.println(result);

		System.out.println(problem322CoinChangeDPTabulation(arr, target));

	}

	private static int problem322CoinChangeDPTabulation(int[] coins, int sum) {
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
