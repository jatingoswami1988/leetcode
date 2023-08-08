package main.binarysearch;

public class Problem_1011_CapacityToShipPackagesWithinDDays {

	public static void main(String agr[]) {

		int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;
		
		int maxCapacity = 0, minCapacity = 0;

		for (int i : weights) {
			maxCapacity += i;
			minCapacity = Math.max(minCapacity, i);
		}

		for (int i = minCapacity; i < maxCapacity; i++) {
			int minDays = getMinDays(weights, i);
			if (minDays <= days) {
				System.out.println("Required answer " + i);
				break;
			}
		}

	}

	private static int getMinDays(int[] weights, int minCapacity) {

		int day = 1;
		int load = 0;
		for (int i = 0; i < weights.length; i++) {
			load = load + weights[i];
			if (load > minCapacity) {
				day++;
				load = weights[i];
			}
		}
		return day;
	}

	public static void main() {

		int weights[] = { 3, 2, 2, 4, 1, 4 };
		int days = 3;

		int maxCapacity = 0, minCapacity = 0;
		for (int i : weights) {
			maxCapacity += i;
			minCapacity = Math.max(minCapacity, i);
		}
		while (minCapacity < maxCapacity) {
			int currCapacity = (minCapacity + maxCapacity) / 2;
			int i = 0, load = 0;
			int day = 0;
			while (i < weights.length) {
				load += weights[i];
				if (load == currCapacity) {
					day++;
					load = 0;
				} else if (load > currCapacity) { // if load is greater then my current capacity then load that in next
													// day
					day++;
					load = weights[i];
				}
				i++;
			}

			if (load != 0) {
				day++;
			}

			if (day <= days) {
				maxCapacity = currCapacity;
			} else if (day > days) {
				minCapacity = currCapacity + 1;
			}
		}
		// return left;

		System.out.println(minCapacity);

	}

}
