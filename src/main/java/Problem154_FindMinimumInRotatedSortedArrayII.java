package main.java;

public class Problem154_FindMinimumInRotatedSortedArrayII {

	public static void main(String ar[]) {

		//int arr[] = { 4, 5, 6, 7, 0, 1, 4 };
		int arr[] = {2,2,2,0,1};
		int pivot = findThePivot(arr);
		System.out.println(pivot == arr.length - 1 ? arr[0] : arr[pivot + 1]);

	}

	private static int findThePivot(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				continue;
			} else if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return arr.length - 1;
	}

}
