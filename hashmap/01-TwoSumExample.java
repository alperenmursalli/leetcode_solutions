// Problem 1: Two Sum
// Difficulty: Easy
// Pattern: HashMap

// Time Complexity: O(n)
// Space Complexity: O(n)

// Explanation:
// I use a HashMap to store each number and its index.
// For every element, I calculate the complement (target - current).
// If the complement already exists in the map, I found the solution.

// Key Insight:
// Instead of using nested loops (O(n^2)), HashMap allows O(1) lookup,
// which makes the solution much faster.

import java.util.HashMap;
import java.util.Map;

class TwoSumExample {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // not found
    }

   public static void main(String[] args) {

    // Test 1
    int[] nums1 = {2, 7, 11, 15};
    int target1 = 9;
    printResult(nums1, target1);

    // Test 2
    int[] nums2 = {3, 2, 4};
    int target2 = 6;
    printResult(nums2, target2);

    // Test 3 (edge case)
    int[] nums3 = {3, 3};
    int target3 = 6;
    printResult(nums3, target3);
}

public static void printResult(int[] nums, int target) {
    int[] result = twoSum(nums, target);
    System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
}
}