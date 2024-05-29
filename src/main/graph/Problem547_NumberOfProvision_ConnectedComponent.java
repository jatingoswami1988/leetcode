package main.graph;

import java.util.ArrayList;

public class Problem547_NumberOfProvision_ConnectedComponent {

	public static void main(String args[]) {

	}

	public int findCircleNum(int[][] isConnected) {
		ArrayList<ArrayList<Integer>> graph = createGraph(isConnected);
		boolean visited[] = new boolean[isConnected.length];
		int connectedComponents = 0;
		for (int i = 0; i < isConnected.length; i++) {
			if (!visited[i]) {
				connectedComponents++;
				runDFS(graph, i, visited);
			}
		}
		return connectedComponents;
	}

	public ArrayList<ArrayList<Integer>> createGraph(int[][] isConnected) {
		ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < isConnected.length; i++) {
			adjListArray.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[i].length; j++) {
				if (isConnected[i][j] == 1 && i != j)
					adjListArray.get(i).add(j);
			}
		}

		return adjListArray;
	}

	public void runDFS(ArrayList<ArrayList<Integer>> adjListArray, int node, boolean[] visited) {
		visited[node] = true;
		for (Integer j : adjListArray.get(node)) {
			if (!visited[j])
				runDFS(adjListArray, j, visited);
		}
	}

}
