package main.slidingWindow;

public class Problem_1493_LongestSubarrayOf1AfterDeletingOneElement {

	public static void main(String[] args) {

		int nums[] = { 1,1,1 };

		int zero = 0;
		int end = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0) {
				zero++;
			}

			if (zero > 1) {
				while (nums[end] != 0) {
					end++;
				}
				zero--;
				end++;
			}

			max = Math.max(max, i - end);

		}

		System.out.println(max);
	}
}
