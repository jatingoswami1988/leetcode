package main.dp;

import java.util.List;

//https://leetcode.com/problems/triangle/solutions/3898397/recursion-memoization-tabulation-space-optimization-full-explaination/

//TODO Undertsand the timecomplexity of the algorithm

public class Problem120_Triangle {

	public static void main(String[] args) {
		
		System.out.println(recursion(0, 0, null));

	}

	private static int recursion(int i, int j, List<List<Integer>> triangle) {
		if (i == triangle.size() - 1)
			return triangle.get(i).get(j);
		return Math.min(triangle.get(i).get(j) + recursion(i + 1, j, triangle),
				triangle.get(i).get(j) + recursion(i + 1, j + 1, triangle));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			dp[n - 1][i] = triangle.get(n - 1).get(i);
		}
		
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				dp[i][j] = Math.min(triangle.get(i).get(j) + dp[i + 1][j], triangle.get(i).get(j) + dp[i + 1][j + 1]);
			}
		}
		
		return dp[0][0];
	}

}
