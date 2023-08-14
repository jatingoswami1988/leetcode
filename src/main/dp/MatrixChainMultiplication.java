package main.dp;

//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
//TODO https://www.geeksforgeeks.org/matrix-chain-multiplication-a-on2-solution/ 
public class MatrixChainMultiplication {

	public static void main(String[] args) {

		 int arr[] = { 40, 20, 30, 10, 30 };
		// int arr[] = { 1, 2, 3, 4, 3 };
		//int arr[] = { 10, 20, 30 };
		System.out.println(recursion(arr, 1, arr.length - 1));
		System.out.println(tabulation(arr, arr.length));
	}

	private static int tabulation(int[] arr, int n) {
		// int m[][] = new int[n][n];
		// for (int L = 2; L < n; L++) {
		// for (int i = 1; i < n - L + 1; i++) {
		// int j = i + L - 1;
		// if (j == n)
		// continue;
		// m[i][j] = Integer.MAX_VALUE;
		// for (int k = i; k <= j - 1; k++) {
		// // q = cost/scalar multiplications
		// int q = m[i][k] + m[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
		// if (q < m[i][j])
		// m[i][j] = q;
		// }
		// }
		// }

		// return m[1][n - 1];

		int dp[][] = new int[n][n];
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j < n; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int count = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
					if (count < min) {
						min = Math.min(min, count);
					}
				}
				dp[i][j] = min;
			}
		}

		return dp[1][n - 1];
	}

	private static int recursion(int[] arr, int i, int j) {

		if (i == j) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			int count = (arr[i - 1] * arr[k] * arr[j]) + recursion(arr, i, k) + recursion(arr, k + 1, j);
			if (count < min) {
				min = Math.min(min, count);
			}
		}

		return min;

	}
}
