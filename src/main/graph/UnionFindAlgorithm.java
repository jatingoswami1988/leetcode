package main.graph;
//https://www.geeksforgeeks.org/introduction-to-disjoint-set-data-structure-or-union-find-algorithm/

public class UnionFindAlgorithm {

	int V = 4;

	private int[] parent = null;
	private int[] rank = null;

	public UnionFindAlgorithm() {
		parent = new int[V];
		rank = new int[V];

		for (int i = 0; i < V; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

	}

	public static void main(String[] args) {

		UnionFindAlgorithm uf = new UnionFindAlgorithm();
		uf.unionFind(0, 1);
		uf.unionFind(1, 3);
		uf.unionFind(3, 2);

		for (int i = 0; i < uf.V; i++) {
			System.out.println("Element " + i + " belongs to the set with representative " + uf.find(i));
		}

	}

	private void unionFind(int i, int j) {

		int iParent = find(i);
		int jParent = find(j);

		if (iParent == jParent) {
			return;
		}

		int iRank = rank[i];
		int jRank = rank[j];

		if (iRank < jRank) {
			parent[jParent] = iParent;
		} else if (iRank > jRank) {
			parent[iParent] = jParent;
		} else {

			parent[jParent] = iParent;
			rank[iParent]++;
		}

	}

	private int find(int i) {
		if (parent[i] != i) {
			parent[i] = find(parent[i]);
		}
		return parent[i];
	}

}
