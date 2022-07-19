package main.java;

public class Problem35_SearchInsertPosition {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 6 };
		int target = 7;

		int low = 0;
		int high = arr.length - 1;
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				// System.out.println(mid);
				result = mid;
				break;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		if (result != -1) {
			System.out.println(result);
		} else {
			System.out.print(low);
		}

	}

}
