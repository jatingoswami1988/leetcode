package main.dp;

public class LongestCommonSubstring {

	public static void main(String[] args) {

		String X = "ab";
		String Y = "ab";

		int n = X.length();
		int m = Y.length();

		//System.out.println(lcsRecusion(X, Y, n, m));
		System.out.println(lcsTabulation(X.toCharArray(), Y.toCharArray(), m, n));

	}

	private static int lcsRecusion(String X, String Y, int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}

		int count = 0;
		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			count = lcsRecusion(X, Y, i - 1, j - 1) + 1;
		}
		count = Math.max(count, Math.max(lcsRecusion(X, Y, i, j - 1), lcsRecusion(X, Y, i - 1, j)));
		return count;
	}

	private static int lcsTabulation(char[] X, char[] Y, int m, int n) {
		int LCStuff[][] = new int[m + 1][n + 1];
		int result = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					LCStuff[i][j] = 0;
				else if (X[i - 1] == Y[j - 1]) {
					LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
					result = Integer.max(result, LCStuff[i][j]);
				} else
					LCStuff[i][j] = 0;
			}
		}
		return result;

	}

}
