// Problem 20: Valid Parentheses
// Difficulty: Easy
// Pattern: Stack

// Time Complexity: O(n)
// Space Complexity: O(n)
//
// Explanation:
// Açılan parantezleri stack'e ekliyoruz.
// Kapanan parantez geldiğinde stack'in tepesindeki elemanla eşleşip eşleşmediğini kontrol ediyoruz.
// Tüm karakterler bittikten sonra stack boşsa bütün parantezler doğru kapanmıştır.
//
// Key Insight:
// En son açılan parantez ilk kapanmalıdır; bu yüzden LIFO mantığı olan stack kullanılır.

package stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ValidParantheses {

    /**
     * Verilen string içindeki parantezlerin geçerli olup olmadığını kontrol eder.
     *
     * @param s Sadece '(', ')', '{', '}','[' ve ']' karakterlerinden oluşan string
     * @return Parantezler doğru sırada kapanıyorsa true, aksi halde false
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            // Açılış parantezlerini daha sonra eşleştirmek için stack'e ekle.
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            // Kapanış parantezi geldiğinde stack boşsa eşleşecek açılış yoktur.
            if (stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();

            // Stack'in tepesindeki açılış parantezi, gelen kapanışla aynı türde olmalı.
            if (ch == ')' && top != '(') return false;
            if (ch == '}' && top != '{') return false;
            if (ch == ']' && top != '[') return false;
        }

        // Stack boşsa açılan tüm parantezler doğru şekilde kapanmıştır.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParantheses sol = new ValidParantheses();

        String s1 = "()";       // expect true
        String s2 = "()[]{}";   // expect true
        String s3 = "(]";       // expect false
        String s4 = "([)]";     // expect false
        String s5 = "{[]}";     // expect true

        System.out.println("Example 1: " + sol.isValid(s1));
        System.out.println("Example 2: " + sol.isValid(s2));
        System.out.println("Example 3: " + sol.isValid(s3));
        System.out.println("Example 4: " + sol.isValid(s4));
        System.out.println("Example 5: " + sol.isValid(s5));
    }
}
