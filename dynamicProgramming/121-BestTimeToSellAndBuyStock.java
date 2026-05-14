// Problem 121: Best Time to Buy and Sell Stock
// Difficulty: Easy
// Pattern: Dynamic Programming
//
// Time Complexity: O(n)
// Space Complexity: O(1)
//
// Explanation:
// Keep track of the lowest stock price seen so far.
// For each day, calculate the profit if we sell on that day.
// profit = prices[i] - buy
//
// Key Insight:
// To maximize profit, we only need the cheapest buy price before the sell day.

package dynamicProgramming;

class BestTimeToSellAndBuyStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int buy = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToSellAndBuyStock sol = new BestTimeToSellAndBuyStock();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit for prices1: " + sol.maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum profit for prices2: " + sol.maxProfit(prices2));

        int[] prices3 = {2, 4, 1};
        System.out.println("Maximum profit for prices3: " + sol.maxProfit(prices3));
    }
}
