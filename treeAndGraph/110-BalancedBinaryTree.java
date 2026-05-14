// Problem 110: Balanced Binary Tree
// Difficulty: Easy
// Pattern: Tree / Depth-First Search

// Time Complexity: O(n^2) in the worst case
// Space Complexity: O(h)

// Explanation:
// For each node, I compare the heights of left and right subtrees.
// If their height difference is more than 1, the tree is not balanced.
// I also recursively check whether left and right subtrees are balanced.

// Key Insight:
// A tree is balanced only if every node satisfies the height condition.

package treeAndGraph;

class BalancedBinaryTree {
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

   int height(TreeNode root) {
      if (root == null) return 0;
      return Math.max(height(root.left), height(root.right)) + 1;
   }

   boolean isBalanced(TreeNode root) {
      if (root == null) return true;
      if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
      return isBalanced(root.left) && isBalanced(root.right);
   }

   public static void main(String[] args) {
      BalancedBinaryTree solution = new BalancedBinaryTree();

      TreeNode balancedRoot = solution.new TreeNode(3);
      balancedRoot.left = solution.new TreeNode(9);
      balancedRoot.right = solution.new TreeNode(20);
      balancedRoot.right.left = solution.new TreeNode(15);
      balancedRoot.right.right = solution.new TreeNode(7);

      TreeNode unbalancedRoot = solution.new TreeNode(1);
      unbalancedRoot.left = solution.new TreeNode(2);
      unbalancedRoot.left.left = solution.new TreeNode(3);
      unbalancedRoot.left.left.left = solution.new TreeNode(4);

      System.out.println("Balanced tree result: " + solution.isBalanced(balancedRoot));
      System.out.println("Unbalanced tree result: " + solution.isBalanced(unbalancedRoot));
   }
}