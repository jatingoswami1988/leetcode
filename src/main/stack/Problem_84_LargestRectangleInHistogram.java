package main.stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/
///https://www.youtube.com/watch?v=tOylVCugy9k
//https://www.youtube.com/watch?v=jC_cWLy7jSI
public class Problem_84_LargestRectangleInHistogram {

	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
		int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
		lessFromRight[height.length - 1] = height.length;
		lessFromLeft[0] = -1;

		for (int i = 1; i < height.length; i++) {
			int p = i - 1;

			while (p >= 0 && height[p] >= height[i]) {
				p = lessFromLeft[p];
			}
			lessFromLeft[i] = p;
		}

		for (int i = height.length - 2; i >= 0; i--) {
			int p = i + 1;

			while (p < height.length && height[p] >= height[i]) {
				p = lessFromRight[p];
			}
			lessFromRight[i] = p;
		}

		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}

		return maxArea;
	}

	static int getMaxArea(int hist[], int n) {
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

	// Driver code
	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };

		// Function call
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}
}
// This code is Contributed by Sumit Ghosh
