// Problem 198: House Robber
// Difficulty: Medium
// Pattern: Dynamic Programming
//
// Time Complexity: O(n)
// Space Complexity: O(1)
//
// Explanation:
// At each house, decide whether to rob it or skip it.
// If we rob the current house, we add its money to the best result from two houses before.
// If we skip it, we keep the best result from the previous house.
// current = max(prevOne, prevTwo + nums[i])
//
// Key Insight:
// We only need the best results from the previous house and two houses before.

package dynamicProgramming;

class HouseRobber {
    public int rob(int[] nums) {

    
        if (nums==null || nums.length==0) return 0;

        if (nums.length==1) return nums[0];

        int[] dp = new int[nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);

        for (int i=2; i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }

        return dp[dp.length-1];

        



        


        
    }

}
