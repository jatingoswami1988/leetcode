package main.java;

public class BinarySearchExample {

	public static void main(String[] args) {
		//int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		int arr[] = {3,1};
		int pivot = findThePivot(arr);
		int target = 3;
		if (target >= arr[0] && target <= arr[pivot]) {
			int low = 0;
			int high = pivot;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (arr[mid] == target) {
					System.out.println(mid);
					break;
				} else if (arr[mid] > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		} else {
			int low = pivot + 1;
			int high = arr.length - 1;
			binarySearch(arr,pivot,low,high);
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (arr[mid] == target) {
					System.out.println(mid);
					break;
				} else if (arr[mid] > target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}

	}

	private static void binarySearch(int[] arr, int pivot, int low, int high) {
		// TODO Auto-generated method stub
		
	}

	private static int findThePivot(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return arr.length-1;
	}
}
