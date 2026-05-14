// Problem 409: Longest Palindrome
// Difficulty: Easy
// Pattern: Greedy / Counting

// Time Complexity: O(n)
// Space Complexity: O(1) (constant 128-char frequency array)

// Explanation:
// Count frequencies of characters. Each pair contributes 2 to the palindrome.
// If any character has an odd count, we can place one odd character in the center.

package greedyAlgorithm;

class LongestPalindrome {

	public int longestPalindrome(String s) {
		int[] freq = new int[128];
		for (char c : s.toCharArray()) freq[c]++;

		int length = 0;
		boolean hasOdd = false;

		for (int f : freq) {
			length += (f / 2) * 2; // add pairs
			if (f % 2 == 1) hasOdd = true;
		}

		if (hasOdd) length++;
		return length;
	}

	public static void main(String[] args) {
		LongestPalindrome sol = new LongestPalindrome();

		String s1 = "abccccdd"; // expect 7 (dccaccd)
		String s2 = "a";        // expect 1
		String s3 = "Aa";       // expect 1 (case-sensitive)

		System.out.println("Example 1: " + sol.longestPalindrome(s1));
		System.out.println("Example 2: " + sol.longestPalindrome(s2));
		System.out.println("Example 3: " + sol.longestPalindrome(s3));
	}
}
