package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class TugOfWar {

	public static int finalDiff = 0;

	public static void main(String[] args) {

		int arr[] = { 3, 9, 7, 3 };
		List<Integer> set1 = new ArrayList<>();
		List<Integer> set2 = new ArrayList<>();
		tugOfWar(arr, 0, set1, set2, 0, 0);
		//tugOfWar1(arr,0, 0,0,set1,set2);

	}

	private static void tugOfWar1(int[] arr, int sumSoFar1, int sumSoFar2,int index, List<Integer> set1, List<Integer> set2) {
		if(index==arr.length) {
			System.out.println("Absolute Difference " + Math.abs(sumSoFar1-sumSoFar2));
			return;
		}		
		
		for (int i = 0; i < 2; i++) {
			set1.add(arr[index]);
			tugOfWar1(arr, index + 1,  sumSoFar1 + arr[index], sumSoFar2,set1,set2);
			set1.remove(set1.size() - 1);
			
			set2.add(arr[index]);
			tugOfWar1(arr, index + 1, sumSoFar1, sumSoFar2 + arr[index],set1,set2);
			set2.remove(set2.size() - 1);
		}
				
	}

	private static void tugOfWar(int[] arr, int index, List<Integer> set1, List<Integer> set2, int sumSoFar1,int sumSoFar2) {

		if (arr.length == index) {
			int delta = Math.abs(sumSoFar2 - sumSoFar1);
			if (finalDiff == 0) {
				finalDiff = delta;
			} else if (delta < finalDiff) {
				finalDiff = delta;
				System.out.println(finalDiff + " - " + set1 + " - " + set2);
			}
			return;
		}

		if (set1.size() < arr.length - 1) {

			set1.add(arr[index]);
			tugOfWar(arr, index + 1, set1, set2, sumSoFar1 + arr[index], sumSoFar2);
			set1.remove(set1.size() - 1);

		}

		if (set2.size() < arr.length - 1) {

			set2.add(arr[index]);
			tugOfWar(arr, index + 1, set1, set2, sumSoFar1, sumSoFar2 + arr[index]);
			set2.remove(set2.size() - 1);

		}
	}

}
