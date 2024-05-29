package main.graph;

import java.util.*;

public class MinTimeTakenByEachJobToBeCompletedGivenByADirectedAcyclicGraph {

	public static final int maxN = 100000;

	@SuppressWarnings("unchecked")
	public static Vector<Integer>[] graph = new Vector[maxN];
	public static int[] indegree = new int[maxN];
	public static int[] job = new int[maxN];

	public static void main(String[] args) {

		int n, m;
		n = 10;
		m = 13;

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new Vector<Integer>();
		}

		addEdge(1, 3);
		addEdge(1, 4);
		addEdge(1, 5);
		addEdge(2, 3);
		addEdge(2, 8);
		addEdge(2, 9);
		addEdge(3, 6);
		addEdge(4, 6);
		addEdge(4, 8);
		addEdge(5, 8);
		addEdge(6, 7);
		addEdge(7, 8);
		addEdge(8, 10);
		printOrder(n, m);
	}

	public static void addEdge(int u, int v) {
		graph[u].add(v);
		indegree[v]++;
	}

	public static void printOrder(int n, int m) {

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				job[i] = 1;
			}
		}

		while (!q.isEmpty()) {
			int cur = q.peek();
			q.remove();
			for (int adj : graph[cur]) {
				indegree[adj]--;
				if (indegree[adj] == 0) {
					job[adj] = 1 + job[cur];
					q.add(adj);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(job[i] + " ");
		}
		System.out.print("\n");
	}
}
