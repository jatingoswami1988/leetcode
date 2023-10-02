package main.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintKSumPathsBinaryTree {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right = new Node(-1);
		List<Integer> path = new ArrayList<>();
		printKSumPathsBinaryTree(root, path);
	}

	private static void printKSumPathsBinaryTree(Node root, List<Integer> path) {

		if (root == null) {
			return;
		}
		path.add(root.key);
		printKSumPathsBinaryTree(root.left, path);
		printKSumPathsBinaryTree(root.right, path);

		int tempSum = 0;
		for (int index = path.size() - 1; index >= 0; index--) {
			tempSum = tempSum + path.get(index);
			if (tempSum == 5) {
				printList(path, index);
			}
		}
		path.remove(path.size() - 1);
	}

	private static void printList(List<Integer> path, int i) {
		for (int j = i; j < path.size(); j++) {
			System.out.print(path.get(j));
		}
		System.out.println("");

	}

}
