package main.stack;

public class Probem_134_GasStation {

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 }, cost = { 3, 4, 5, 1, 2 };
		System.out.println(findIndex(gas, cost));

	}

	private static int findIndex(int[] p, int[] c) {
		int extra = 0;
		int rem = 0;
		int start = 0;
		for (int i = 0; i < p.length; i++) {
			extra = extra + (p[i] - c[i]);
			if (extra < 0) {
				rem = rem + extra;
				start = i + 1;
				extra = 0;
			}
		}

		if (rem + extra >= 0) {
			return start;
		} else {
			return -1;
		}
	}

}
