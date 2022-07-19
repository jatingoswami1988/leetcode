package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem169_MajorityElement {

	public static void main(String args[]) {

		// int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
		// int arr[] = { 3,2,3};

		int arr[] = {3,2,3};

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		List<Integer> l = new ArrayList<Integer>();
		//int count = 0;
		// for(Map.Entry<Integer,Integer> m : map.entrySet()) {
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) >= (arr.length / 3)) {
				//count++;
				l.add(arr[i]);
			}
			// }
		}

		//l.add(count);
		System.out.println(l);

		List<String> list = Arrays.asList("Jatin", "Sakshi", "Jatin", "Nitin", "Jatin", "Sakshi");

		/*
		 * for(int i = 0; i < arr.length; i++) { if (map.containsKey(arr[i])) { int
		 * count = map.get(arr[i]) +1; if (count > arr.length /2) {
		 * System.out.println(arr[i]); } else map.put(arr[i], count);
		 * 
		 * } else map.put(arr[i],1); }
		 * 
		 * //System.out.println(" No Majority element"); if(arr.length==1) {
		 * System.out.println("1"); }
		 */
	}

}
