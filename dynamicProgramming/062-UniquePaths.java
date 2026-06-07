// Problem 62: Unique Paths
// Difficulty: Medium
// Pattern: Dynamic Programming
//
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
//
// Explanation:
// The robot can only move  right or down.
// To reach any cell, it can come from the cell above or the cell on the left.
// So paths[i][j] = paths[i - 1][j] + paths[i][j - 1].
//
// Key Insight:
// The first row and first  column have  only one possible path because the robot can move in only one direction.

package dynamicProgramming;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();

        int m1 = 3;
        int n1 = 7;
        System.out.println("Unique paths for 3x7 grid: " + sol.uniquePaths(m1, n1));

        int m2 = 3;
        int n2 = 2;
        System.out.println("Unique paths for 3x2 grid: " + sol.uniquePaths(m2, n2));

        int m3 = 1;
        int n3 = 5;
        System.out.println("Unique paths for 1x5 grid: " + sol.uniquePaths(m3, n3));
    }
}
