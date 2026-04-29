// Problem 108: Convert Sorted Array to Binary Search Tree
// Difficulty: Medium
// Pattern: Tree / Divide and Conquer

// Time Complexity: O(n)
// Space Complexity: O(log n) (recursion stack for balanced tree)

// Explanation:
// Choose the middle element as the root to ensure the tree is height-balanced.
// Recursively build left and right subtrees from subarrays.

// Key Insight:
// Picking the middle converts a sorted array into a height-balanced BST in O(n).

package treeAndGraph;

import java.util.ArrayList;
import java.util.List;

class ConvertSortedArrayToBinarySearchTree {

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

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] nums, int l, int r) {
		if (l > r) return null;
		int mid = l + (r - l) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = build(nums, l, mid - 1);
		node.right = build(nums, mid + 1, r);
		return node;
	}

	// Helper: preorder traversal to visualize structure
	private void preorder(TreeNode root, List<Integer> out) {
		if (root == null) return;
		out.add(root.val);
		preorder(root.left, out);
		preorder(root.right, out);
	}

	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree sol = new ConvertSortedArrayToBinarySearchTree();

		int[] nums1 = {-10, -3, 0, 5, 9};
		TreeNode root1 = sol.sortedArrayToBST(nums1);
		List<Integer> pre1 = new ArrayList<>();
		sol.preorder(root1, pre1);
		System.out.println("Preorder of BST from [-10,-3,0,5,9]: " + pre1);

		int[] nums2 = {1, 3};
		TreeNode root2 = sol.sortedArrayToBST(nums2);
		List<Integer> pre2 = new ArrayList<>();
		sol.preorder(root2, pre2);
		System.out.println("Preorder of BST from [1,3]: " + pre2);
	}
}
