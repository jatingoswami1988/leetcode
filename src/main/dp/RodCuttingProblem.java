package main.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCuttingProblem {

	public static void main(String[] args) {
		
		

	}
	
	public int tabulation(int n, int[] cuts) {
		Arrays.sort(cuts);
		int c = cuts.length;
		List<Integer> list = new ArrayList<>();
		list.add(0);
		for (int i = 0; i < c; i++) {
			list.add(cuts[i]);
		}

		list.add(n);

		int dp[][] = new int[c + 2][c + 2];

		for (int i = c; i >= 1; i--) {
			for (int j = i; j <= c; j++) {
				int mini = Integer.MAX_VALUE;
				for (int ind = i; ind <= j; ind++) {
					int cutting = list.get(j + 1) - list.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
					mini = Math.min(mini, cutting);
				}
				dp[i][j] = mini;
			}
		}
		return dp[1][c];
	}

}
