package main.dp;

import java.util.Arrays;
//https://takeuforward.org/data-structure/minimum-maximum-falling-path-sum-dp-12/
public class Problem_931_MinimumMaximumFallingPathSum {

	public static void main(String[] args) {

		int[][] a = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		int min = Integer.MAX_VALUE;
		int m = a.length;
		int n = a[0].length;

		//for (int j = 0; j < n; j++) {
	//		int temp = minRecursion(a);
		//	min = Math.min(min, temp);
		//}

		System.out.println(min);
	}

	public int minTabulation(int[][] a) { // bottom up
		int min = Integer.MAX_VALUE;
		int m = a.length;
		int n = a[0].length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);

		for (int j = 0; j < n; j++) { //Base Case
			dp[j] = a[0][j];
		}

		for (int i = 1; i < m; i++) {
			int[] curr = new int[n];
			for (int j = 0; j < n; j++) {

				int left = a[i][j];
				if (j > 0)
					left += dp[j - 1];
				else
					left += (int) Math.pow(10, 9);

				int up = a[i][j] + dp[j];

				int right = a[i][j];
				if (j < a[0].length - 1)
					right += dp[j + 1];
				else
					right = (int) Math.pow(10, 9);

				curr[j] = Math.min(left, Math.min(up, right));
			}
			dp = curr;
		}

		for (int j = 0; j < n; j++) {
			min = Math.min(min, dp[j]);
		}
		return min;
	}

	public int minRecursion(int[][] a) {
		int min = Integer.MAX_VALUE;
		int m = a.length;
		int n = a[0].length;

		for (int j = 0; j < n; j++) {
			int temp = recursion(a, m - 1, j);
			min = Math.min(min, temp);
		}
		return min;
	}

	public int recursion(int[][] a, int i, int j) {

		if (i < 0 || j < 0 || j > a[0].length - 1)
			return (int) Math.pow(10, 9);
		if (i == 0)
			return a[i][j];

		int left = a[i][j] + recursion(a, i - 1, j - 1);
		int up = a[i][j] + recursion(a, i - 1, j);
		int right = a[i][j] + recursion(a, i - 1, j + 1);

		return Math.min(left, Math.min(up, right));
	}
}
