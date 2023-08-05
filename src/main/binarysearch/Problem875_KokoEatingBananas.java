package main.binarysearch;

public class Problem875_KokoEatingBananas {

	public static void main(String[] args) {

		int piles[] = { 3, 6, 7, 11 };
		int h = 8;
		int left = 1;
		int right = Integer.MIN_VALUE;
		for (int pile : piles) {
			right = Math.max(right, pile);
		}
		while (left < right) {
			int mid = left + (right - left) / 2;
			int time = 0;
			for (int pile : piles) {
				time += pile % mid == 0 ? pile / mid : (pile / mid) + 1;
			}
			if (time > h) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		System.out.println(left);
	}

}
