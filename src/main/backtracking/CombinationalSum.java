package main.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {

	public static void main(String[] args) {

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(4);
		// arr.add(6);
		// arr.add(8);

		// Set<Integer> set = new HashSet<>(arr);
		// arr.clear();
		// arr.addAll(set);
		// Collections.sort(arr);

		int sum = 7;

		findNumbers(result, arr, sum, 0, new ArrayList<>());
		int[] n = { 2, 3, 6, 7 };
		System.out.println(combinationSum(n, sum));
		System.out.println(result);

	}

	@SuppressWarnings("unchecked")
	private static void findNumbers(List<List<Integer>> result, List<Integer> arr, int sum, int index,
			List<Integer> temp) {

		if (sum == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = index; i < arr.size(); i++) {
			if ((sum - arr.get(i)) >= 0) {
				temp.add(arr.get(i));
				findNumbers(result, arr, sum - arr.get(i), index, temp);
				temp.remove(arr.get(i));
			}
		}
	}

	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	private int count(int coins[], int n, int sum) {

		// If sum is 0 then there is 1 solution
		// (do not include any coin)
		if (sum == 0)
			return 1;

		// If sum is less than 0 then no
		// solution exists
		if (sum < 0)
			return 0;

		// If there are no coins and sum
		// is greater than 0, then no
		// solution exist
		if (n <= 0)
			return 0;

		// count is sum of solutions (i)
		// including coins[n-1] (ii) excluding coins[n-1]
		return count(coins, n - 1, sum) + count(coins, n, sum - coins[n - 1]);
	}
}
