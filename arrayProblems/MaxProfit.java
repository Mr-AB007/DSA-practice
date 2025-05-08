/**
 * Problem: Given an array of integers `prices` where `prices[i]` is the price of a given stock on the ith day,
 * find the maximum profit you can achieve from buying and selling the stock. You are only allowed to buy once and sell once.
 * 
 * Approach:
 * - Initialize `buy` to positive infinity to represent the minimum price to buy.
 * - Initialize `max_profit` to 0 to track the maximum profit.
 * - Iterate through the `prices` array to find the minimum buying price and calculate the profit for each day.
 * - Update `max_profit` whenever a higher profit is found.
 * 
 * Time Complexity: O(n), where `n` is the length of the array `prices`.
 * Space Complexity: O(1), as we are using a constant amount of extra space.
 */


//Greedy Algorithm Pattern
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int curr : prices) {
            if (buy > curr) {
                buy = curr;
            }

            int curr_profit = curr - buy;
            if (curr_profit > max_profit) {
                max_profit = curr_profit;
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        MaxProfit solution = new MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit: " + solution.maxProfit(prices));
    }
}
