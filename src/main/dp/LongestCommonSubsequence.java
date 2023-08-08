package main.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String s1 = "abcd";
		String s2 = "bd";

		System.out.println(longestCommonSubsequenceRecursion(s1, s2, s1.length(), s2.length()));
		System.out.println(longestCommonSubsequence(s1, s2));

	}

	public static int longestCommonSubsequence(String text1, String text2) {

		int m = text1.length();
		int n = text2.length();

		char[] X = text1.toCharArray();
		char[] Y = text2.toCharArray();

		int L[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	private static int longestCommonSubsequenceRecursion(String a, String b, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		} else if (a.charAt(m - 1) == b.charAt(n - 1)) {
			return 1 + longestCommonSubsequenceRecursion(a, b, m - 1, n - 1);
		} else {
			return max(longestCommonSubsequenceRecursion(a, b, m - 1, n),
					longestCommonSubsequenceRecursion(a, b, m, n - 1));
		}

	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
