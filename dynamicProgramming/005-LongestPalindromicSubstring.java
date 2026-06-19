// Problem 5: Longest Palindromic Substring
// Difficulty: Medium
// Pattern: Dynamic Programming
//
// Time   Complexity: O(n^2)
// Space Complexity: O(n^2)
//
// Explanation:
// Use a DP table where dp[i][j] tells whether s.substring(i, j + 1) is a palindrome.
// A substring is a pali  ndrome if i ts first and last characters match and the inside substring is also a palindrome.
// dp[i][j] = s.charAt(i) ==  s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])
//
// Key Insight:
// Short substrings are the base cases, and longer substrings depend on the result of their inner substring.

package dynamicProgramming;

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start=0;
        int maxLen=1;

        for (int i=0; i<n; i++){
            dp[i][i]=true;
            
        }

        for (int i=0; i<n-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                maxLen=2;
            }
        }

        for (int len=3; len<=n;len++){
            for (int i=0;i<=n-len;i++){
                int j = i+len-1;

                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                    dp[i][j]=true;
                    start =i;
                    maxLen=len;
                }
    
            }
        }
        return s.substring(start,start+maxLen);

        }

}
