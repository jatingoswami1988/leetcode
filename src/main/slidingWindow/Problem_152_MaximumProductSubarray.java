package main.slidingWindow;

public class Problem_152_MaximumProductSubarray {

	public static void main(String agr[]) {

		// int arr[] = { 2, 3, -2, 4 };
		int arr[] = { 2, 3, -2, 4 };

		// System.out.println(maxProduct(arr));
		System.out.println(maxPro(arr));
	}

	private static int maxPro(int[] arr) {
		int ans = 0;

		int ma = arr[0];
		int mi = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < 0) {
				int temp = ma;
				ma = mi;
				mi = temp;
			}

			ma = Math.max(arr[i], ma * arr[i]);
			mi = Math.min(arr[i], mi * arr[i]);
			ans = Math.max(ma, ans);

		}

		return ans;
	}

	public static int maxProduct(int[] nums) {
		int largestProduct = nums[0];
		int minCurrentProduct = nums[0];
		int maxCurrentProduct = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int currentProduct = Math.max(maxCurrentProduct * nums[i], nums[i]);// 6

			if (minCurrentProduct * nums[i] > currentProduct)
				currentProduct = minCurrentProduct * nums[i];

			int temp = Math.min(maxCurrentProduct * nums[i], nums[i]);// 3

			if (minCurrentProduct * nums[i] > temp)//
				minCurrentProduct = temp;// 3
			else
				minCurrentProduct = minCurrentProduct * nums[i];

			maxCurrentProduct = currentProduct;// 6
			largestProduct = Math.max(maxCurrentProduct, largestProduct);// 6
		}

		return largestProduct;
	}
}