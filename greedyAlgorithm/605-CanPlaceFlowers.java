// Problem 605: Can Place Flowers
// Difficulty: Easy
// Pattern: Greedy / Array

// Time Complexity: O(n)
// Space Complexity: O(1)

// Explanation:
// Try to plant flowers greedily: whenever you find an empty spot whose
// neighbors are empty (or edges), plant there and decrement n.

package greedyAlgorithm;

import java.util.Arrays;

class CanPlaceFlowers {

	// Placeholder implementation. Replace with greedy planting logic.
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		// TODO: implement greedy algorithm to place n flowers
		return false;
	}

	public static void main(String[] args) {
		CanPlaceFlowers sol = new CanPlaceFlowers();

		if (args.length == 0) {
			int[] sample = {1,0,0,0,1};
			System.out.println("Sample flowerbed: " + Arrays.toString(sample));
			System.out.println("(placeholder) canPlaceFlowers: " + sol.canPlaceFlowers(sample, 1));
			System.out.println("Usage: java -cp . greedyAlgorithm/605-CanPlaceFlowers <space-separated flowerbed> <n>");
			return;
		}

		try {
			int len = args.length - 1;
			int[] bed = new int[len];
			for (int i = 0; i < len; i++) bed[i] = Integer.parseInt(args[i]);
			int n = Integer.parseInt(args[args.length - 1]);

			System.out.println("Input flowerbed: " + Arrays.toString(bed) + ", n=" + n);
			System.out.println("(placeholder) canPlaceFlowers: " + sol.canPlaceFlowers(bed, n));
		} catch (NumberFormatException e) {
			System.err.println("Invalid arguments. Provide integers only.");
		}
	}
}
