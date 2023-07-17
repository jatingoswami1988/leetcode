package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Problem_698PartitionToKEqualSumSubsets {
	public static boolean result = true;

	public static void main(String[] args) {

		int arr[] = { 9, 5, 9, 5 };
		int k = 3;
		int[] subSetSum = new int[k];
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}

		System.out.println(solution(arr, 0, subSetSum, 0, ans, k, false));

	}

	private static boolean solution(int[] arr, int index, int[] subSetSum, int tempSum, List<List<Integer>> ans, int k,
			boolean flag) {
		if (arr.length == index) {
			if (tempSum == k) {
				 boolean flag1 = true;
				for (int i = 0; i < subSetSum.length - 1; i++) {
					if (subSetSum[i] != subSetSum[i + 1]) {
						flag1 = true;
						// return false;
						break;
					}
				}
				if (flag1) {
					for (List<Integer> partition : ans) {
						System.out.println(partition + " ");
					}
				}
			}
			return flag;
		} else {
			for (int i = 0; i < ans.size(); i++) {
				if (ans.get(i).size() > 0) {
					ans.get(i).add(arr[index]);
					subSetSum[i] += arr[index];
					solution(arr, index + 1, subSetSum, tempSum, ans, k, flag);
					subSetSum[i] -= arr[index];
					ans.get(i).remove(ans.get(i).size() - 1);
				} else {
					ans.get(i).add(arr[i]);
					subSetSum[i] += arr[index];
					solution(arr, index + 1, subSetSum, tempSum + 1, ans, k, flag);
					subSetSum[i] -= arr[index];
					ans.get(i).remove(ans.get(i).size() - 1);
					break;
				}
			}
		}

		return flag;
	}
}
