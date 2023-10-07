package main.dp;

//https://leetcode.com/problems/house-robber-ii/solutions/3881298/memoization-tabulation-space-optimization/
public class HouseOfRobber_2 {

	public static void main(String[] args) {
		int nums[] = {1,2,3};	
		System.out.println(rob(nums));
		
	}

	public static int rob(int[] nums) {
		int n = nums.length;
		if (nums.length == 1)
			return nums[0];
		int dp[] = new int[n + 1];
		//Arrays.fill(dp, -1);
		int includefirst[] = new int[n];
		int includelast[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				includefirst[i] = nums[i];
			}
			if (i != n - 1) {
				includelast[i] = nums[i];
			}
		}
		return Math.max(tabulation(includefirst, dp), tabulation(includelast, dp));
	}

	private static int tabulation(int[] arr, int dp[]) {

		dp[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int take = arr[i] + (i > 1 ? dp[i - 2] : 0);
			int notTake = 0 + dp[i - 1];
			dp[i] = Math.max(take, notTake);
		}

		return dp[arr.length - 1];
	}

	public int solve(int[] nums, int dp[]) {
		dp[nums.length] = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int take = nums[i];
			if (i < nums.length - 2) {
				take += dp[i + 2];
			}
			int nottake = 0 + dp[i + 1];
			dp[i] = Math.max(take, nottake);
		}
		return dp[0];
	}

}
