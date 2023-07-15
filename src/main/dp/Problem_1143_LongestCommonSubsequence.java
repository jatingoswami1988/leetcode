package main.dp;

public class Problem_1143_LongestCommonSubsequence {

	public static void main(String args[]) {

		String s1 = "abcdefghij";
		String s2 = "cdgi";
		System.out.println("Recursion - " + lcs(s1, s2, s1.length(), s2.length()));
		System.out.println("DP - " + lcsDP(s1, s2, s1.length(), s2.length()));
	}

	// Recursion
	private static int lcs(String s1, String s2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		} else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return 1 + lcs(s1, s2, m - 1, n - 1);
		} else
			return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
	}

	// DP
	private static int lcsDP(String s1, String s2, int m, int n) {
		int L[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

}
