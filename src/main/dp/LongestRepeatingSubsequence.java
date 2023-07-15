package main.dp;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {

		String s1 = "abacbc";
		System.out.println("Recursion - " + lps(s1, s1, s1.length(), s1.length()));
		System.out.println("DP - " + lpsDP(s1, s1, s1.length(), s1.length()));

	}

	// Recursion
	private static int lps(String s1, String s2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		} else if (s1.charAt(m - 1) == s2.charAt(n - 1) && m != n) {
			return 1 + lps(s1, s2, m - 1, n - 1);
		} else
			return Math.max(lps(s1, s2, m - 1, n), lps(s1, s2, m, n - 1));
	}

	// DP
	private static int lpsDP(String s1, String s2, int m, int n) {
		int L[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j)
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}

		String res = "";
		int i = n, j = n;
		while (i > 0 && j > 0) {

			if (L[i][j] == L[i - 1][j - 1] + 1) {
				res = res + s1.charAt(i - 1);
				i--;
				j--;
			} else if (L[i][j] == L[i - 1][j]) {
				i--;
			} else {
				j--;
			}
		}

		String reverse = "";
		for (int k = res.length() - 1; k >= 0; k--) {
			reverse = reverse + res.charAt(k);
		}
		System.out.println("String "+reverse);
		return L[m][n];
	}

}
