// Problem 70: Climbing Stairs
// Difficulty: Easy
// Pattern: Dynamic Programming
//
// Time Complexity: O(n)
// Space Complexity: O(n)
//
// Explanation:
// At each stair i, you can reach it from stair i-1 or i-2.
// So ways(i) = ways(i-1) + ways(i-2), which is a Fibonacci sequence.
//
// Key Insight:
// This is a classic DP problem where each state depends on previous states.

package dynamicProgramming;

class ClimbingStairs {
    public int climbStairs(int n) {
        if (n<=2) return n;

        int[] dp = new int[n+1];

        dp[1]=1;
        dp[2]=2;

        for (int i=3;i <=n ; i++){
            dp[i]=dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();

        int n1 = 3;
        System.out.println("Distinct ways to climb " + n1 + " stairs: " + sol.climbStairs(n1));

        int n2 = 4;
        System.out.println("Distinct ways to climb " + n2 + " stairs: " + sol.climbStairs(n2));

        int n3 = 5;
        System.out.println("Distinct ways to climb " + n3 + " stairs: " + sol.climbStairs(n3));
    }
}