package binarytree;

public class InvertTree {
	BinaryTreeNode root;

	/**
	 * The time complexity of the `invertTree` method can be expressed as O(n),
	 * where n is the number of nodes in the binary tree. This is because the method
	 * traverses each node of the tree once.
	 * 
	 * As for the space complexity, it's O(h), where h is the height of the binary
	 * tree. This is because the method utilizes recursion, and the maximum depth of
	 * the recursion stack is equal to the height of the binary tree.
	 * 
	 */
	public BinaryTreeNode invertTree(BinaryTreeNode root) {
		if (root == null) {
			return root;
		}
		invertTree(root.left);
		invertTree(root.right);
		BinaryTreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
