package main.tree;

public class KthSmallestAndLargestNoInBST {

	public static int count = 0;

	public static void main(String ars[]) {

		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		//root.right = new Node(22);
	//	root.right.left = new Node(15);
	//	root.right.right = new Node(7);
		kthSmallest(root);

	}

	private static void kthSmallest(Node root) {
		if (root == null) {
			return;
		} else {
			kthSmallest(root.left);
			count++;
			if (count == 3) {
				System.out.println(root.key);
			}
			kthSmallest(root.right);
		}

	}

}
