package main.dp;

public class Problem583_DeleteOperationForTwoStrings {

	public static void main(String[] args) {
		String word1 = "sea", word2 = "eat";
		System.out.println((word1.length() - longestCommonSubsequence(word1,word2)) + (word2.length() - longestCommonSubsequence(word1,word2)));

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

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
