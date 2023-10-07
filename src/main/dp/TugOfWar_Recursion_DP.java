package main.dp;

public class TugOfWar_Recursion_DP {

	public static void main(String[] args) {
		int arr[] = { 1, 2 };
		int n = arr.length;
		System.out.print(recursion(arr, n));
		System.out.print(tabulation(arr, n));
	}

	private static int recursion(int[] arr, int n) {
		int sumTotal = 0;
		for (int i = 0; i < n; i++) {
			sumTotal += arr[i];
		}

		return findMinRec(arr, n, 0, sumTotal);
	}

	public static int findMinRec(int arr[], int i, int sumCalculated, int sumTotal) {

		if (i == 0) {
			return Math.abs((sumTotal - sumCalculated) - sumCalculated);
		}

		return Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i - 1], sumTotal),
				findMinRec(arr, i - 1, sumCalculated, sumTotal));
	}

}
