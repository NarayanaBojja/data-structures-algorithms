package binarytree;

/**
 * Time Complexity: O(N) As every node is visited once. Auxiliary Space: O(N)
 * The extra space is due to the recursion call stack and the worst case occurs
 * when the tree is either left skewed or right skewed.
 */
public class BinaryTreeSize {
	BinaryTreeNode root;

	static int binarySize(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		return binarySize(root.left) + 1 + binarySize(root.right);

	}

	public static void main(String[] args) {
		BinaryTreeSize tree = new BinaryTreeSize();
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);

		System.out.println("The size of binary tree is : " + binarySize(tree.root));

	}

}
