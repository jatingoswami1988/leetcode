package main.twopointer;

import java.util.Arrays;

public class Problem_322_CoinChange {

	public static void main(String[] args) {

		int coins[] = { 186, 419, 83, 408 };// 83 , 186 , 408 , 419
		int amount = 6249;
		int temp = amount;
		Arrays.sort(coins);
		int index = coins.length - 1;
		int result = 0;
		
		while (index >= 0) {

			if (temp - coins[index] >= 0) {
				result++;
				temp = temp - coins[index];
			} else {
				index--;
			}

		}
		
		if (temp > 0)
			System.out.println(-1);
		System.out.println(result == 0 ? -1 : result);

	}

}
