package main.dp;

public class LongestIncreasingSequence {

	// Stores the LIS
	static int max_ref;

	public static void main(String[] args) {

		//int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int arr[] = {3,10};
		int result = lis(arr);
		int result1 = R(arr, arr.length);
		System.out.println(result);
		System.out.println(result1);

	}

	private static int R(int[] arr, int n) {
		if (n == 1)
			return 1;

		int res, max_ending_here = 1;

		for (int i = 1; i < n; i++) {
			res = R(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		if (max_ref < max_ending_here)
			max_ref = max_ending_here;

		return max_ending_here;
	}

	private static int lis(int[] arr) {

		int dp[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}

		return max;
	}

}
