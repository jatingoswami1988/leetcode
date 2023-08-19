package main.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/solutions/2101165/recursion-memoization-bottom-up-dp-table/
public class Problem1547MinimumCostToCutAStick {

	public static void main(String[] args) {
		int cuts[] = { 1, 3, 4, 5 };

		int n = 7;
		System.out.println(tabulation(n, cuts));
		Arrays.sort(cuts);
		int c = cuts.length;
		List<Integer> list = new ArrayList<>();
		list.add(0);
		for (int i = 0; i < c; i++) {
			list.add(cuts[i]);
		}
		list.add(n);
		System.out.println(recursion(1, cuts.length, list));
	}

	private static int recursion(int i, int j, List<Integer> list) {
		if (i > j) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int index = i; index <=j; index++) {
			int cutting = (list.get(j + 1) - list.get(i - 1))
					+ recursion(i, index - 1, list)
					+ recursion(index + 1, j, list);
			min = Math.min(min, cutting);
		}
		
		return min;
	}

	private static int tabulation(int n, int[] cuts) {
		
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

	// private static int resursion(int i, int j) {
//	if(i<j) return 0;
	// int min = Integer.MAX_VALUE;
	// for(int index = ) {
	//
	// int cost = cuts[j+1] - cuts[i-1] + resursion(i, index - 1) + recusion(index
	// +1,j);
	// min = Math.min(min, cost);
	// }
	// return min;
	// }

}
