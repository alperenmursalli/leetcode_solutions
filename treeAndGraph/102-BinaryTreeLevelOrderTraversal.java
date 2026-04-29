// Problem 102: Binary Tree Level Order Traversal
// Difficulty: Medium
// Pattern: Tree / Breadth-First Search

// Time Complexity: O(n)
// Space Complexity: O(n)

// Explanation:
// Use a queue to traverse the tree level by level. For each level, record
// all node values in a list and add children for the next level.

// Key Insight:
// BFS (queue) naturally groups nodes by depth, making it simple to build
// a list of lists representing each level.

package treeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {}

		TreeNode(int val) { this.val = val; }

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				level.add(node.val);

				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
			}

			res.add(level);
		}

		return res;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

		// Example 1: [3,9,20,null,null,15,7]
		TreeNode root1 = solution.new TreeNode(3);
		root1.left = solution.new TreeNode(9);
		root1.right = solution.new TreeNode(20);
		root1.right.left = solution.new TreeNode(15);
		root1.right.right = solution.new TreeNode(7);

		System.out.println("Level order 1: " + solution.levelOrder(root1));

		// Example 2: single node
		TreeNode root2 = solution.new TreeNode(1);
		System.out.println("Level order 2: " + solution.levelOrder(root2));
	}
}

