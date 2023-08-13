package main.dp;

//https://leetcode.com/problems/minimum-path-sum/solutions/3348642/java-dp-as-well-as-recursive-solution/
//https://www.geeksforgeeks.org/min-cost-path-dp-6/
public class Problem_64MinimumPathSum {

	public static void main(String[] args) {

		int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(recursion(grid, grid.length - 1, grid[0].length - 1));
	}

	private static int recursion(int[][] arr, int i, int j) {

		if (i == 0 && j == 0) {
			return arr[0][0];
		} else if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		} else {
			int up = recursion(arr, i - 1, j);
			int left = recursion(arr, i, j - 1);
			return arr[i][j] + Math.min(up, left);
		}
	}
	
	public int tabulation(int cost[][]){
		int m = cost.length;
        int n = cost[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = cost[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + cost[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = cost[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
	}
}
