package main.backtracking;

public class MColouringProblem {

	public static int R = -1;
	public static int C = -1;

	public static void main(String[] args) {

		// int graph[][] = { { 0, 1, 1, 1 },
		// { 1, 0, 1, 0 },
		// { 1, 1, 0, 1 },
		// { 1, 0, 1, 0 }, };
		int graph[][] = { { 0, 1, 1 },
						  { 1, 0, 1 },
						  { 1, 1, 0 } };

		int k = 1;

		R = graph.length;
		C = graph[0].length;

		int visited[] = new int[R];
		System.out.println(graphColouringProblem(graph, R, C, 0, 0, k, visited, 0));

	}

	private static boolean graphColouringProblem(int[][] graph, int R, int C, int r, int c, int k, int[] visited,
			int vertex) {

		if (vertex == R) {
			return true;
		}

		for (int color = 1; color <= k; color++) {

			if (isSafe(graph, vertex, visited, color)) {
				visited[vertex] = color;

				if (graphColouringProblem(graph, R, C, r, c, k, visited, vertex + 1)) {
					return true;
				}
				// backtrack
				visited[vertex] = 0;
				// return false;// move to next colour
			}

		}
		return false;
	}

	private static boolean isSafe(int[][] graph, int vertex, int[] visited, int color) {
		for (int i = 0; i < C; i++) {
			if (graph[vertex][i] == 1 && visited[i] == color) {
				return false;
			}
		}
		return true;
	}

}
