package main.dp;

public class SubSetSum_Recursion_DP {

	public static void main(String[] args) {

		//int arr[] = { 1, 4, 7, 9 };
		int arr[] = { 3,37 };
		System.out.println(subsetSumRecursion(arr, arr.length, 41, 41,"")); // O(2^n) exponential

	}

	private static boolean subsetSumRecursion(int[] arr, int n, int tempSum, int targetSum, String result) {

		if (tempSum == 0) {
			System.out.println(result);
			return true;
		}

		if (n == 0)
			return false;

		if (arr[n - 1] > targetSum) {
			return subsetSumRecursion(arr, n - 1, tempSum, targetSum, result);
		}

		return subsetSumRecursion(arr, n - 1, tempSum - arr[n - 1], targetSum, result + "-" + arr[n - 1])
				|| subsetSumRecursion(arr, n - 1, tempSum, targetSum, result);
	}

}
