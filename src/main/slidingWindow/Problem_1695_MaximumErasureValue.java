package main.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class Problem_1695_MaximumErasureValue {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 4, 5, 6 };
		int sum = 0;
		int max = 0;
		int left = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			
			if (!set.contains(arr[i])) {
				sum = sum + arr[i];
				set.add(arr[i]);
			} else {
				
				while (arr[left] != arr[i]) {
					sum = sum - arr[left];
					set.remove(arr[left++]);
				}

				// removing the previous duplicate and incrementing left
				sum = sum - arr[left];
				set.remove(arr[left++]);

				// adding current i after removing from first position
				sum = sum + arr[i];
				set.add(arr[i]);
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
