package main.dp;

public class MaximumSumSuchThatNoTwoElementsAreAdjacent_HouseOfRobber {

	public static int max = 0;

	public static void main(String[] args) {

		int arr[] = { 5, 5, 10, 100, 10, 5 };
		System.out.println(recursion(arr, arr.length - 1));
		System.out.println(tabulation(arr));
		
	}

	
	private static int tabulation(int[] arr) {

		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int take = arr[i] + (i > 1 ? dp[i - 2] : 0);
			int notTake = 0 + dp[i - 1];
			dp[i] = Math.max(take, notTake);
		}

		return dp[arr.length-1];
	}


	// Recursion
	private static int recursion(int[] arr, int index) {
		if (index == 0)
			return arr[index];

		if (index < 0) {
			return 0;
		}

		int include = arr[index] + recursion(arr, index - 2);
		int dontInclude = recursion(arr, index - 1);

		return Math.max(include, dontInclude);
	}
	
	
	// Another way
	public static int findMaxSum(int[] arr, int n) {
		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		for (i = 1; i < n; i++) {
			excl_new = (incl > excl) ? incl : excl;
			incl = excl + arr[i];
			excl = excl_new;
		}

		return ((incl > excl) ? incl : excl);
	}
}
