// Problem 55: Jump Game
// Difficulty: Medium
// Pattern: Greedy

// Time Complexity: O(n)
// Space Complexity: O(1)

// Explanation:
// Track the farthest index reachable while iterating. If the current index
// exceeds the farthest reachable index, we cannot progress further.

// Key Insight:
// Greedy approach works by always extending the reachable range; no need
// to explore all paths.

package greedyAlgorithm;

class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            
            if (i > farthest) {
                return false;
            }

         
            farthest = Math.max(farthest, i + nums[i]);

       
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println("Jump Game example 1: " + sol.canJump(nums1));
        System.out.println("Jump Game example 2: " + sol.canJump(nums2));
    }
}