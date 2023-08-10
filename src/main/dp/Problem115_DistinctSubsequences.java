package main.dp;

import java.util.HashSet;
import java.util.Set;

// https://www.youtube.com/watch?v=nVG7eTiD2bY
// pick and dont pick logic
//https://www.geeksforgeeks.org/count-distinct-subsequences/
//https://leetcode.com/problems/distinct-subsequences/solutions/2738744/recursion-to-dp-optimise-easy-understanding/
public class Problem115_DistinctSubsequences {

	public static void main(String agrs[]) {

		String s = "babgbag";
		String t = "bag";
		System.out.println(recursion(s, t, s.length() - 1, t.length() - 1));
		System.out.println(tabulation(s, t));

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

	private static int recursion(String s, String t, int i, int j) {

		if (j < 0) // if all characters of s2 is matches and j is exhausted -> then return 1
			return 1;
		if (i < 0) // main string is exhausted
			return 0;

		if (s.charAt(i) == t.charAt(j)) {
			return recursion(s, t, i - 1, j - 1) + recursion(s, t, i - 1, j);
		} else {
			return recursion(s, t, i - 1, j);
		}
	}

	public static void main() {

		String s = "babgbag", t = "bag";
		// String s = "ggg", t = "bag";
		char[] op = new char[s.length() + 1];
		Set<String> result = new HashSet<>();
		distinctSubsequencesUsingRecusion(result, s.toCharArray(), op, s.length(), 0, 0);
		System.out.println(result);
	}

	private static void distinctSubsequencesUsingRecusion(Set<String> result, char[] s, char[] t, int length, int i,
			int j) {

		if (i == length) {
			t[j] = '\0';
			result.add(String.valueOf(t));
			return;
		} else {
			t[j] = s[j];
			distinctSubsequencesUsingRecusion(result, s, t, length, i + 1, j + 1);
			distinctSubsequencesUsingRecusion(result, s, t, length, i + 1, j);
			return;
		}

	}

}
