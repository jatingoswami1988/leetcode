package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem15_3Sum {

	public static void main(String agrs[]) {

		// int arr[] = { 1, 5, 2, 3, 7, 1, 0 };
		// int sum = 8;

		int arr[] = { -1, 0, 1, 2, -1, -4 };
		int sum = 0;

		List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {

			int temp = sum - arr[i];
			for (int j = i + 1; j < arr.length - 1; j++) {
				List<Integer> result = new ArrayList<Integer>();
				int tempInner = temp - (arr[j]);
				if (map.containsKey(tempInner)) {					
					if (i != j && j != map.get(tempInner) && map.get(tempInner) != i) {
						result.add(arr[i]);
						result.add(arr[j]);
						result.add(tempInner);
					}

					// result.add(i);
					// result.add(j);
					// result.add(map.get(tempInner));

				}
				map.put(arr[j], j);
				if (result.size() > 0)
					finalResult.add(result);
			}
			map = new HashMap<Integer, Integer>();
		}
	}

}
