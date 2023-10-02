package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum {

	public static void main(String[] args) {

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(4);
		//arr.add(6);
		//arr.add(8);
		
		//Set<Integer> set = new HashSet<>(arr);
		//arr.clear();
		//arr.addAll(set);
		//Collections.sort(arr);

		int sum = 6;
		
		findNumbers(result, arr, sum, 0, new ArrayList<>());
		
		System.out.println(result);
		
	}

	@SuppressWarnings("unchecked")
	private static void findNumbers(List<List<Integer>> result, List<Integer> arr, int sum, int index, List<Integer> temp) {

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
}
