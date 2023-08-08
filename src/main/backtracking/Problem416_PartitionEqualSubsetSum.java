package main.backtracking;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/solutions/3578167/recursive-to-space-optimized-tabulation-code/
// pick and dont pick logic
// recursion 
// tabulation
public class Problem416_PartitionEqualSubsetSum {

	public static void main(String[] args) {

		int arr[] = { 1,5,11,5 };
		System.out.println(canPartitionKSubsets(arr));

	}

	public static boolean canPartitionKSubsets(int[] arr) {
		int sum = 0;
		for (int i : arr)
			sum += i;
		if (sum % 2 != 0)
			return false;
		Arrays.sort(arr);

		return (partition(arr, sum / 2));
	}

	public static boolean partition(int[] arr, int target) {

		boolean dp[][] = new boolean[arr.length + 1][target + 1];

		for (int i = 1; i <= target; i++) {
			dp[0][i] = false;
		}

		for (int i = 0; i <= arr.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= arr.length; i++) {

			for (int j = 1; j <= target; j++) {
							// dont pick    // dont pick
				dp[i][j] = dp[i - 1][j] || ((arr[i - 1] <= j) ? dp[i - 1][j - arr[i - 1]] : false);

			}
		}

		return dp[arr.length][target];
	}

}
