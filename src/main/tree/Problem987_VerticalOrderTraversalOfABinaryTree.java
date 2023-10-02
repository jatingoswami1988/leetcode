package main.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem987_VerticalOrderTraversalOfABinaryTree {

	public static void main(String[] args) {

		Node root = new Node(3);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.left = new Node(15);
		root.right.right = new Node(7);

		// 3
		// 9 20
		// 15 //7
		List<List<Integer>> result = verticalOrderTraversalOfABinaryTree(root);
		System.out.println(result);
	}

	private static List<List<Integer>> verticalOrderTraversalOfABinaryTree(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		diagnol(root, 0, map);
		list.addAll(map.values());
		return list;
	}

	private static void diagnol(Node root, int horizontalDistance, Map<Integer, List<Integer>> map) {
		if (root == null) {
			return;
		}

		List<Integer> list = map.get(horizontalDistance);
		if (list == null) {
			list = new ArrayList<>();
			list.add(root.key);
		} else {
			list.add(root.key);
		}
		map.put(horizontalDistance, list);
		diagnol(root.left, horizontalDistance - 1, map);
		diagnol(root.right, horizontalDistance + 1, map);
	}

}
