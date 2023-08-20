package main.dp;

public class Porblem_221_MaximalSquare {
	public static void main(String agr[]) {
		char mat[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(maximalSquare(mat));
	}

	public static int maximalSquare(char[][] matrix) {
		return tabulation(matrix);
	}

	public static int tabulation(char[][] matrix) {
		int dp[][] = new int[matrix.length][matrix[0].length];
		int result = 0;
		for (int i = 0; i < dp.length; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
				result = 1;
			}
		}
		for (int j = 0; j < dp[0].length; j++) {
			if (matrix[0][j] == '1') {
				dp[0][j] = 1;
				result = 1;
			}
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					result = Math.max(dp[i][j], result);
				}
			}
		}
		return result * result;
	}
}