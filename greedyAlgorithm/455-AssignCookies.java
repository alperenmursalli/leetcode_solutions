// Problem 455: Assign Cookies
// Difficulty: Easy
// Pattern: Greedy
//
// Time Complexity: O(n log n + m log m)
// Space Complexity: O(1)
//
// Explanation:
// Sort children by greed factor and cookies by size.
// Always try to satisfy the least greedy child with the smallest possible cookie.
//
// Key Insight:
// If the smallest available cookie cannot satisfy the current child,
// it cannot satisfy any greedier child either, so we try a bigger cookie.

package greedyAlgorithm;

import java.util.Arrays;

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }

            cookie++;
        }

        return child;
    }

    public static void main(String[] args) {
        AssignCookies sol = new AssignCookies();

        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println("Content children for example 1: " + sol.findContentChildren(g1, s1));

        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println("Content children for example 2: " + sol.findContentChildren(g2, s2));

        int[] g3 = {10, 9, 8, 7};
        int[] s3 = {5, 6, 7, 8};
        System.out.println("Content children for example 3: " + sol.findContentChildren(g3, s3));
    }
}