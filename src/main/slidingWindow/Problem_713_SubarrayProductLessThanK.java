package main.slidingWindow;

public class Problem_713_SubarrayProductLessThanK {

	public static void main(String[] args) {

		int nums[] = { 1,2,3 };
		int k = 0;

		int start = 0;
		int tempSum = 1;
		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			tempSum = tempSum * nums[i];
			while (start < i && tempSum >= k) {
				tempSum = tempSum / nums[start];
				start++;
			}
			if (tempSum < k) {
				result = result + (i - start + 1);
			}
		}

		System.out.println(result);

	}

}
