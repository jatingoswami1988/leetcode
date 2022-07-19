package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem322_CoinChange {

	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int arr[] = { 1, 2, 5 };
		int target = 10;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		Collections.sort(list);

		cs(result, list, new ArrayList<Integer>(), target);

	}

	private static void cs(List<List<Integer>> result, List<Integer> list,List<Integer> arrayList, int target) {
		
		

	}

}
