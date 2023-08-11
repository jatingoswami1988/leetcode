package main.dp;

public class Porblem_121_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {

		int arr[] = { 7, 1, 5, 3, 6, 4 };

		int minValue = arr[0];
		int maxProfit = 0;
		int maxValue = 0;

		if (arr.length < 2) {
			System.out.println(0);
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minValue)
				minValue = arr[i];

			maxProfit = arr[i] - minValue;
			maxValue = Math.max(maxValue, maxProfit);

		}
		
		System.out.println(maxValue);
	}
}
