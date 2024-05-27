package tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode {
	int key;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int data) {
		key = data;
	}
}

public class BinaryTree {
	BinaryTreeNode root;

	public void preOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.key + " ");
	}

	public void inOrder(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}

	public void levelOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			System.out.print(temp.key + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new BinaryTreeNode(4);
		bt.root.left = new BinaryTreeNode(7);
		bt.root.right = new BinaryTreeNode(9);
		bt.root.right.left = new BinaryTreeNode(10);
		bt.root.left.left = new BinaryTreeNode(5);
		System.out.println("preOrder");
		bt.preOrder(bt.root);
		System.out.println("\npostOrder");
		bt.postOrder(bt.root);
		System.out.println("\ninOrder");
		bt.inOrder(bt.root);
		System.out.println("\nLevel order");
		bt.levelOrder(bt.root);
	}

}
