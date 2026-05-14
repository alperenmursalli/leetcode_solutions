// Problem 118: Pascal's Triangle
// Difficulty: Easy
// Pattern: Dynamic Programming
//
// Time Complexity: O(numRows^2)
// Space Complexity: O(numRows^2)
//
// Explanation:
// Each row starts and ends with 1.
// Every middle value is calculated by adding the two values above it.
// triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]
//
// Key Insight:
// Store previous rows so the current row can reuse already calculated values.

package dynamicProgramming;

import java.util.*;

class PascalTriangles {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int val = dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j);
                    row.add(val);
                }
            }

            dp.add(row);
        }

        return dp;
    }

    public static void main(String[] args) {
        PascalTriangles sol = new PascalTriangles();

        int numRows1 = 5;
        System.out.println("Pascal's Triangle with " + numRows1 + " rows: " + sol.generate(numRows1));

        int numRows2 = 1;
        System.out.println("Pascal's Triangle with " + numRows2 + " row: " + sol.generate(numRows2));

        int numRows3 = 3;
        System.out.println("Pascal's Triangle with " + numRows3 + " rows: " + sol.generate(numRows3));
    }
}
