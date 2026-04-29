// Problem 104: Maximum Depth of Binary Tree
// Difficulty: Easy
// Pattern: Tree / Depth-First Search

// Time Complexity: O(n)
// Space Complexity: O(h)

// Explanation:
// I recursively compute the height of the left and right subtrees.
// The maximum depth of the tree is the larger subtree depth plus 1.

// Key Insight:
// Each node is visited once, and the recursion depth depends on the tree height.

// Given the root of a binary tree, return its maximum depth.

package treeAndGraph;

class MaximumDepthOfBinaryTree {
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

    int height(TreeNode root){
        if (root==null) return -1;

        return Math.max(height(root.left),height(root.right))+1;
    } 

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.right.left = solution.new TreeNode(15);
        root.right.right = solution.new TreeNode(7);

        int depth = solution.height(root) + 1;
        System.out.println("Maximum Depth: " + depth);
    }

    /*
    public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int level = 0;

    while (!q.isEmpty()) {
        int size = q.size();

        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        level++;
    }

    return level;
}*/
    


}
