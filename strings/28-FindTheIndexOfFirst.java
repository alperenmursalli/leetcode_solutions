// Problem 28: Find the Index of the First Occurrence in a String
// Difficulty: Easy
// Pattern: String Matching / Boyer-Moore-Horspool
//
// Time Complexity: O(n * m) in the worst case
// Space Complexity: O(1)
//
// Explanation:
// Search for needle inside haystack by comparing from right to left.
// When a mismatch happens, shift the window using the bad character table.
//
// Key Insight:
// Precomputing shift distances lets the algorithm skip characters instead of
// checking every starting position one by one.

package strings;

class FindTheIndexOfFirst {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;
        if (m > n) return -1;

        int[] shift = new int[256];

        // 1) Başta tüm karakterlere m ver
        for (int i = 0; i < 256; i++) {
            shift[i] = m;
        }

        // 2) Needle'ın son karakteri hariç shift değerlerini hesapla.
        for (int i = 0; i < m - 1; i++) {
            shift[needle.charAt(i)] = m - 1 - i;
        }

        int i = 0;

        while (i <= n - m) {
            int j = m - 1;

            // Sağdan sola karşılaştır
            while (j >= 0 && haystack.charAt(i + j) == needle.charAt(j)) {
                j--;
            }

            // j < 0 ise hepsi eşleşti
            if (j < 0) {
                return i;
            }

            // Needle'ın son karakterinin altındaki haystack karakterine göre kaydır
            char c = haystack.charAt(i + m - 1);
            i += shift[c];
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfFirst sol = new FindTheIndexOfFirst();

        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("First index of \"" + needle1 + "\" in \"" + haystack1 + "\": " + sol.strStr(haystack1, needle1));

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("First index of \"" + needle2 + "\" in \"" + haystack2 + "\": " + sol.strStr(haystack2, needle2));

        String haystack3 = "hello";
        String needle3 = "ll";
        System.out.println("First index of \"" + needle3 + "\" in \"" + haystack3 + "\": " + sol.strStr(haystack3, needle3));
    }
}
