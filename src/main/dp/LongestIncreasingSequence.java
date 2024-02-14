package main.dp;

public class LongestIncreasingSequence {

	public static void main(String[] args) {

		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

		int result = lis(arr);
		System.out.println(result);

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
