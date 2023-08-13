package main.dp;

//https://www.youtube.com/watch?v=sdE0A2Oxofw
public class Problem_62UniquePaths {

	public static void main(String[] args) {
		int m = 3, n = 7;
		System.out.println(recursion(m - 1, n - 1));
		System.out.println(tabulation(m, n));

	}

	private static int tabulation(int m, int n) {

		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	private static int recursion(int m, int n) {
		if (m == 0 && n == 0) {
			return 1;
		}
		if (m < 0 || n < 0) {
			return 0;
		}

		int left = recursion(m - 1, n);
		int up = recursion(m, n - 1);

		return left + up;
	}

}
