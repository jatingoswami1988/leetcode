package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem136_SingleNumber {

	public static void main(String[] args) {

		//int arr[] = { 2, 2, 1 };
		
		int arr[] = {4,1,2,1,2};
		Arrays.sort(arr);
		
		/*for(int i=0;i<arr.length;i++) {
			if(arr[i] != arr[i+1]) {
				System.out.println(arr[i]);
				break;
			}
		}*/
		
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			result.put(arr[i], result.getOrDefault(arr[i], 0) + 1);
		}

		for (int i = 0; i < arr.length; i++)
			if (result.get(arr[i]) == 1) {
				System.out.println(arr[i]);

			}

	}

}
