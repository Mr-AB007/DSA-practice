class Solution {
    /*
     * LeetCode Problem 121: Best Time to Buy and Sell Stock
     *
     * Given an array prices where prices[i] is the price of a given stock on the ith day,
     * you want to maximize your profit by choosing a single day to buy one stock and choosing
     * a different day in the future to sell that stock. Return the maximum profit you can achieve
     * from this transaction. If you cannot achieve any profit, return 0.
     *
     * Example:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buy > prices[i])
                buy = prices[i];
            else if (max < prices[i] - buy)
                max = prices[i] - buy;
        }
        return max;
    }
}
