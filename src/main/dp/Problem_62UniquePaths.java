package main.dp;

//https://www.youtube.com/watch?v=sdE0A2Oxofw
//https://www.geeksforgeeks.org/find-the-number-of-islands-using-dfs/
public class Problem_62UniquePaths {

	public static void main(String[] args) {
		int arr[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		// int m = 3, n = 7;
		System.out.println(recursion(arr, 0, 0, arr.length, arr[0].length));
		System.out.println(tabulation(arr));

	}

	private static int tabulation(int[][] grid) {

		int m = grid.length, n = grid[0].length;
		int dp[][] = new int[m + 1][n + 1];
		if (grid[0][0] != 1)
			dp[1][1] = 1;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				if (grid[i - 1][j - 1] != 1)
					dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
		return dp[m][n];
	}

	private static int recursion(int[][] grid, int r, int c, int m, int n) {
		if (r == m || c == n || grid[r][c] == 1)
			return 0;
		if (r == m - 1 && c == n - 1) {
			if (grid[r][c] == 1) {
				return 0;
			} else {
				return 1;
			}
		}
		int right = recursion(grid, r + 1, c, m, n);
		int down = recursion(grid, r, c + 1, m, n);
		return right + down;
	}

}
