package main.backtracking;

public class RatInMaze {

	public static int N = -1;

	public static void main(String[] args) {

		int maze[][] = { { 1, 0 }, { 1, 1 } };
		N = maze.length;
		solveMaze(maze);
	}

	private static void solveMaze(int[][] maze) {

		int sol[][] = new int[maze.length][maze[0].length];

		if (solveMazeUtil(maze, 0, 0, sol)) {
			System.out.println("Solution exists");
			// printTheSolution();
		} else {
			System.out.println("Solution does not exists");
		}

	}

	private static boolean solveMazeUtil(int[][] maze, int row, int col, int[][] sol) {

		// Base condition
		if (row == N - 1 && col == N - 1 && maze[row][col] == 1) {
			sol[row][col] = 1;
			return true;
		}

		if (safe(maze, row, col)) {

			if (sol[row][col] == 1) {
				return false;
			}

			sol[row][col] = 1;

			if (solveMazeUtil(maze, row + 1, col, sol)) {
				return true;
			}

			if (solveMazeUtil(maze, row, col + 1, sol)) {
				return true;
			}

			sol[row][col] = 0;
			return false;

		}

		return false;
	}

	private static boolean safe(int[][] maze, int x, int y) {
		return (x < N && y < N && maze[x][y] == 1);
	}

}
