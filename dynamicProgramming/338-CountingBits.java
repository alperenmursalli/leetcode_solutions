// Problem 338: Counting Bits
// Difficulty: Easy
// Pattern: Dynamic Programming / Bit Manipulation
//
// Time Complexity: O(n)
// Space Complexity: O(n)
//
// Explanation:
// For every number i, the number of 1 bits can be found from i / 2.
// bits[i] = bits[i >> 1] + (i & 1)
//
// Key Insight:
// Right shifting removes the last bit, and (i & 1) tells whether that last bit is 1.

package dynamicProgramming;

import java.util.Arrays;

class CountingBits  {
    public int[] CountingBits(int n)    {
    
    int[] bits = new int[n + 1];

    bits[0]=0;

    for (int i=0;i<=n;i++){
        bits[i]=bits[i>>1]+(i&1);
    }
    return bits;
}

    public static void main(String[] args) {
        CountingBits sol = new CountingBits();

        int n1 = 2;
        System.out.println("Counting bits from 0 to " + n1 + ": " + Arrays.toString(sol.CountingBits(n1)));

        int n2 = 5;
        System.out.println("Counting bits from 0 to " + n2 + ": " + Arrays.toString(sol.CountingBits(n2)));

        int n3 = 8;
        System.out.println("Counting bits from 0 to " + n3 + ": " + Arrays.toString(sol.CountingBits(n3)));
    }
}
