package main.slidingWindow;

public class Problem_930BinarySubarraysWithSum {

	public static void main(String[] args) {

		int arr[] = { 1, 0, 1, 0, 1 };
		int goal = 2;

		int start = 0;
		int end = 0;
		int sum = 0;
		int result = 0;
		while (end < arr.length) {
			sum = sum + arr[end++];
			if (sum == goal) {
				result++;
			}

		}

		while (start < arr.length) {
			sum = sum - arr[start];
			start++;
			if (sum == goal) {
				result++;
			}
		}

		System.out.println(result);

	}

}
