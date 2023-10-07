package main.dp;

import java.util.ArrayList;
import java.util.List;

public class CountOfSubsetsWithSumEqualToX_Recusion_DP {

	public static void main(String[] args) {

		int arr[] = { 1, 1, 1, 1 }, X = 1;
		List<List<Integer>> result = new ArrayList<>();
		countOfSubsetsWithSumEqualToX(arr, arr.length, result, new ArrayList<>(), 0, X);
		System.out.println(result);
	}

	private static void countOfSubsetsWithSumEqualToX(int[] arr, int n, List<List<Integer>> result,
			List<Integer> tempList, int subSetSum, int X) {

		if (n == 0) {
			if (subSetSum == X) {
				result.add(new ArrayList<>(tempList));

			}
			return;
		}

		countOfSubsetsWithSumEqualToX(arr, n - 1, result, new ArrayList<>(tempList), subSetSum, X);
		tempList.add(arr[n - 1]);
		countOfSubsetsWithSumEqualToX(arr, n - 1, result, new ArrayList<>(tempList), subSetSum + arr[n - 1], X);

	}

}
