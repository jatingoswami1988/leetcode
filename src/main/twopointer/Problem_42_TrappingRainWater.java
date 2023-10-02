package main.twopointer;

public class Problem_42_TrappingRainWater {

	public static void main(String[] args) {

		// int arr[] = { 1,8,6,2,5,4,8,3,7};

		int arr[] = { 3, 0, 2, 0, 4 };

		int left[] = new int[arr.length];

		int right[] = new int[arr.length];

		left[0] = arr[0];

		right[arr.length - 1] = arr[arr.length - 1];

		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

		int water = 0;

		for (int i = 0; i < arr.length; i++) {
			water = water + Math.min(left[i], right[i]) - arr[i];
		}

		System.out.println(water);

	}

}
