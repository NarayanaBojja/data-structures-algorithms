package binarytree;

/**
 * Given a root of a tree, and an integer k. Print all the nodes which are at k
 * distance from root.
 */
public class PrintKDistance {

	BinaryTreeNode root;

	/**
	 * Time Complexity: O(n) where n is number of nodes in the given binary tree.
	 * Space Complexity : O(height of the binary tree).
	 */
	public void printKDistnace(BinaryTreeNode binaryTreeNode, int k) {

		if (binaryTreeNode == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(binaryTreeNode.key);
		}
		printKDistnace(binaryTreeNode.left, k - 1);
		printKDistnace(binaryTreeNode.right, k - 1);
	}

	public static void main(String[] args) {
		PrintKDistance pd = new PrintKDistance();
		pd.root = new BinaryTreeNode(4);
		pd.root.left = new BinaryTreeNode(7);
		pd.root.right = new BinaryTreeNode(9);
		pd.root.right.left = new BinaryTreeNode(10);
		pd.root.left.left = new BinaryTreeNode(5);
		pd.root.left.left.right = new BinaryTreeNode(6);
		pd.printKDistnace(pd.root, 2);
	}

}
