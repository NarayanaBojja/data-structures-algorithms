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

	/**
	 * time complexity : O(n)
	 * 
	 * @param root
	 */
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

	void insert(int key) {
		root = insertRec(root, key);
	}

	private BinaryTreeNode insertRec(BinaryTreeNode root, int key) {
		if (root == null) {
			root = new BinaryTreeNode(key);
			return root;
		}
		if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	boolean search(int key) {
		return searchRec(root, key);
	}

	private boolean searchRec(BinaryTreeNode root, int key) {
		if (root == null) {
			return false;
		}
		if (root.key == key) {
			return true;
		}
		if (key < root.key) {
			return searchRec(root.left, key);
		}
		return searchRec(root.right, key);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(6);
		bt.insert(2);
		bt.insert(1);
		bt.insert(7);
		bt.insert(3);
		bt.insert(8);
		bt.insert(9);
		System.out.println("preOrder");
		bt.preOrder(bt.root);
		System.out.println("\npostOrder");
		bt.postOrder(bt.root);
		System.out.println("\ninOrder");
		bt.inOrder(bt.root);
		System.out.println("\nLevel order");
		bt.levelOrder(bt.root);
		System.out.println(" \nElement 7 found: " + bt.search(7));
	}

}
