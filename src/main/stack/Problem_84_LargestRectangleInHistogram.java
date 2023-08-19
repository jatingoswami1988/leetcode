package main.stack;

import java.util.Stack;
//https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/
///https://www.youtube.com/watch?v=tOylVCugy9k
public class Problem_84_LargestRectangleInHistogram {
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
