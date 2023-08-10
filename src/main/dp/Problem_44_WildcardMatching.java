package main.dp;

//https://www.youtube.com/watch?v=ZmlQ3vgAOMo
///
public class Problem_44_WildcardMatching {

	public static void main(String[] args) {
		String p = "c*a*b";
		String s = "aab";
		
		System.out.println(recursion(p, s, p.length() - 1, s.length() - 1));
		// System.out.println(tabulation(s, t));

	}

	private static boolean recursion(String p, String s, int i, int j) {

		if (i < 0 && j < 0)
			return true;
		if (i < 0 && j >= 0)
			return false;
		if (j < 0 && i >= 0) {
			for (int ii = 0; ii <= i; ii++) {
				if (p.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
			return recursion(p, s, i - 1, j - 1);
		} else if (p.charAt(i) == '*') {
			return recursion(p, s, i - 1, j) || recursion(p, s, i, j - 1);
		} else {
			return false;
		}
	}

	private static int tabulation(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				dp[i][j] = dp[i - 1][j];
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i][j] + dp[i - 1][j - 1];
				}
			}
		}
		return dp[s.length()][t.length()];
	}

}
