package main.java;

// Java program to find all combinations that
// sum to a given value
import java.io.*;
import java.util.*;

public class Problem39_CombinationSum {

	public static List<List<Integer>> combinationSum(List<Integer> arr, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Set<Integer> set = new HashSet<>(arr);
		arr.clear();
		arr.addAll(set);
		Collections.sort(arr);

		findNumbers(ans, arr, sum, 0, temp);
		return ans;
	}

	public static void findNumbers(List<List<Integer>> ans, List<Integer> arr, int sum, int index, List<Integer> temp) {

		if (sum == 0) {
			// Adding deep copy of list to ans
			ans.add(new ArrayList<>(temp));
			return;
		}

		for (int i = index; i < arr.size(); i++) {
			// checking that sum does not become negative
			if ((sum - arr.get(i)) >= 0) {
				// adding element which can contribute to
				// sum
				temp.add(arr.get(i));
				findNumbers(ans, arr, sum - arr.get(i), i, temp);
				// removing element from list (backtracking)
				temp.remove(arr.get(i));
			}
		}
	}

	// Driver Code

	public static void main(String[] args) {
		int arr[] = { 2, 2, 4 };
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		list.add(2);
		list.add(4);
		// arr.add(6);
		// arr.add(8);
		int sum = 6;

		List<List<Integer>> ans = combinationSum(list, sum);

		// If result is empty, then
		if (ans.size() == 0) {
			System.out.println("Empty");
			return;
		}

		System.out.println(ans);
	}
}
