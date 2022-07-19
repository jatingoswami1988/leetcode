package main.java;

public class Problem53_MaximumSubarray {

	public static void main(String[] args) {

		int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int x = Integer.MIN_VALUE;
		int y = 0;

		for (int i = 0; i < arr.length; i++) {
			y = y + arr[i];
			if (x < y) {
				x = y;
			}

			if (y < 0) {
				y = 0;
			}
		}

		System.out.println(x);

	}

}
