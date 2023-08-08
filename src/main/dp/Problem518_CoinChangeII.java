package main.dp;

public class Problem518_CoinChangeII {

	public static void main(String[] args) {

		/*
		 * Input: amount = 5, coins = [1,2,5] Output: 4 Explanation: there are four ways
		 * to make up the amount: 5=5 5=2+2+1 5=2+1+1+1 5=1+1+1+1+1
		 */

		int coins[] = { 1, 2, 5 };
		int amount = 5;

		int temp[][] = new int[coins.length + 1][amount + 1];

		temp[0][0] = 1;

		for (int j = 1; j <= amount; j++) {
			temp[0][j] = 0;
		}

		for (int i = 1; i <= coins.length; i++) {
			temp[i][0] = 1;
			for (int j = 1; j <= amount; j++) {
				temp[i][j] = temp[i - 1][j] + (j >= coins[i - 1] ? temp[i][j - coins[i - 1]] : 0);
			}
		}

		System.out.println(temp[coins.length][amount]);

	}

}
