package main.dp;

import java.util.Stack;
//https://leetcode.com/problems/maximal-rectangle/solutions/
// leftArray and rightArray Solution
public class Porblem_85_MaximalRectangle {

	public static void main(String[] args) {
		// char c = '1';
		// System.out.println(Character.getNumericValue(c));
		// System.out.println(Integer.parseInt(
		// String.valueOf(c)));
		char matrix[][] = { { '0', '1' }, { '1', '0' } };
		System.out.println(maximalRectangle(matrix));

	}

	public static int maximalRectangle(char[][] matrix) {

		int max = 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int arr[] = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					arr[j] = 0;
				} else {
					arr[j] =arr[j] + 1;
				}
			}

			max = Math.max(max, getMaxArea(arr, arr.length));
		}

		return max;
	}

	public static int getMaxArea(int hist[], int n) {
		Stack<Integer> s = new Stack<>();

		int max_area = 0;
		int tp;
		int area_with_top;
		int i = 0;
		while (i < n) {
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);
			else {
				tp = s.peek();
				s.pop();
				area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
				if (max_area < area_with_top)
					max_area = area_with_top;
			}
		}

		while (s.empty() == false) {
			tp = s.peek();
			s.pop();
			area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}

		return max_area;
	}
}
