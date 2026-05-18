// Problem 561: Array Partition I
// Difficulty: Easy
// Pattern: Greedy / Sorting

// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1) (in-place sort) or O(n) depending on sort

// Explanation:
// After sorting, pairing adjacent elements (0&1, 2&3, ...) maximizes the
// sum of minimums in each pair.

package greedyAlgorithm;

import java.util.Arrays;

class ArrayPartition {

	public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        
        for (int i=0;i<nums.length/2;i++){
            sum+=nums[2*i];
        }
        return sum;
		
	}

		public static void main(String[] args) {
		ArrayPartition sol = new ArrayPartition();

		if (args.length == 0) {
			int[] sample = {1, 4, 3, 2};
			System.out.println("Sample input: " + Arrays.toString(sample));
			System.out.println("(placeholder) arrayPairSum: " + sol.arrayPairSum(sample));
			System.out.println("Usage: java -cp . greedyAlgorithm/561-ArrayPartition <n1> <n2> ...");
			return;
		}

		try {
			int[] nums = new int[args.length];
			for (int i = 0; i < args.length; i++) nums[i] = Integer.parseInt(args[i]);

			System.out.println("Input: " + Arrays.toString(nums));
			System.out.println("(placeholder) arrayPairSum: " + sol.arrayPairSum(nums));
		} catch (NumberFormatException e) {
			System.err.println("Invalid number in arguments. Provide integers only.");
		}
	}
}
