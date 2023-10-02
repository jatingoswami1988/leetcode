package main.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintPathRootGivenNodeBinaryTree {

	public static void main(String[] args) {
		
		//// IMPORTANT

		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);
		List<Integer> arr = new ArrayList<>();
		boolean flag = printPathRootGivenNodeBinaryTree(root, arr, 8);
		if (flag) {
			System.out.println("Present");
		} else {
			System.out.println("Not Present");
		}

	}

	private static boolean printPathRootGivenNodeBinaryTree(Node root, List<Integer> arr, int x) {

		if (root == null) {
			return false;
		}

		arr.add(root.key);

		if (root.key == x) {
			return true;
		}

		if (printPathRootGivenNodeBinaryTree(root.left, arr, x)
				|| printPathRootGivenNodeBinaryTree(root.right, arr, x)) {
			return true;
		}

		arr.remove(arr.size() - 1);

		return false;

	}

}
