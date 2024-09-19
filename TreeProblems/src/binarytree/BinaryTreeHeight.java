package binarytree;

public class BinaryTreeHeight {

	BinaryTreeNode root;

	/**
	 * Time Complexity: O(n), as it traverses the tree only once. Auxiliary Space:
	 * O(h), where h is the height of the tree, this space is due to the recursive
	 * call stack.
	 */
	static int maxDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lDepth = maxDepth(root.left);
			int rDepth = maxDepth(root.right);
			if (lDepth > rDepth) {
				return lDepth + 1;
			} else {
				return rDepth + 1;
			}
		}
	}

	/**
	 * Time Complexity: O(n), as it traverses the tree only once. Auxiliary Space:
	 * O(h), where h is the height of the tree, this space is due to the recursive
	 * call stack.
	 */
	static int minDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		
		BinaryTreeHeight bt = new BinaryTreeHeight();
		bt.root = new BinaryTreeNode(4);
		bt.root.left = new BinaryTreeNode(7);
		bt.root.right = new BinaryTreeNode(9);
		bt.root.right.left = new BinaryTreeNode(10);
		bt.root.left.left = new BinaryTreeNode(5);
		bt.root.left.left.right = new BinaryTreeNode(6);

		System.out.println(maxDepth(bt.root));
	    System.out.println(minDepth(bt.root));
	}

}
