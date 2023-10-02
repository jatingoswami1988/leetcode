package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermuationOfNumberUsingBacktracking {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		List<List<Integer>> result = new ArrayList<>();
		permuationOfStringUsingBacktracking(numbers, result, new ArrayList<>());
		System.out.print(result);
	}

	private static void permuationOfStringUsingBacktracking(List<Integer> numbers, List<List<Integer>> result,
			List<Integer> temp) {
		if (temp.size() == numbers.size()) {
			result.add(new ArrayList<Integer>(temp));
		}

		for (int num : numbers) {
			if (temp.contains(num))
				continue;
			temp.add(num);
			permuationOfStringUsingBacktracking(numbers, result, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
