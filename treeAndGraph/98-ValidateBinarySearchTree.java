// Problem 98: Validate Binary Search Tree
// Difficulty: Medium
// Pattern: Tree / DFS / Recursion

// Time Complexity: O(n)
// Space Complexity: O(h)

// Explanation:
// I validate each node using a value range (min, max).
// Left subtree values must be strictly smaller than the current node.
// Right subtree values must be strictly greater than the current node.

// Key Insight:
// Checking only parent-child relation is not enough.
// Every node must satisfy all ancestor constraints.

package treeAndGraph;

class ValidateBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isValidBST(TreeNode root) {
		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean validate(TreeNode node, long min, long max) {
		if (node == null) return true;

		if (node.val <= min || node.val >= max) return false;

		return validate(node.left, min, node.val)
				&& validate(node.right, node.val, max);
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

		// Valid BST: [2,1,3]
		TreeNode validRoot = solution.new TreeNode(2);
		validRoot.left = solution.new TreeNode(1);
		validRoot.right = solution.new TreeNode(3);

		// Invalid BST: [5,1,4,null,null,3,6]
		TreeNode invalidRoot = solution.new TreeNode(5);
		invalidRoot.left = solution.new TreeNode(1);
		invalidRoot.right = solution.new TreeNode(4);
		invalidRoot.right.left = solution.new TreeNode(3);
		invalidRoot.right.right = solution.new TreeNode(6);

		System.out.println("Valid tree result: " + solution.isValidBST(validRoot));
		System.out.println("Invalid tree result: " + solution.isValidBST(invalidRoot));
	}
}
