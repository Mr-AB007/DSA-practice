class BuyAndSellStocks2 {
/**
 * Problem Statement:
 * You are given an array 'prices' where prices[i] is the price of a given stock on the i-th day.
 * You are allowed to complete at most two transactions (i.e., buy and sell the stock at most twice).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Objective:
 * Return the maximum profit you can achieve from at most two transactions.
 *
 * Constraints:
 * - 0 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 *
 * Example:
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 5 (price = 3), profit = 3.
 *              Then buy on day 6 (price = 1) and sell on day 7 (price = 4), profit = 3.
 *              Total profit = 3 + 3 = 6.
 */

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int max = 0;
        int max1 = 0;

        for(int i = 0 ; i < prices.length ; i++){
            int curr = prices[i];
            if(buy > curr){
                buy = curr;
            }
            else if(i < prices.length-1 && curr > prices[i+1]){
                max1 += curr - buy;
                buy = curr;
                max = 0;
            }
            else if(max < prices[i] - buy)
                max = prices[i] - buy;

        }
        return max + max1;
    }

    //greedy approach
    
public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
           ;
    }

//using DP
public int maxProfit(int[] A) {                        
        int n = A.length, lastBuy = -A[0], lastSold = 0;
        if (n == 0) return 0;
                                
        for (int i = 1; i < n; i++) {
            int curBuy = Math.max(lastBuy, lastSold - A[i]);
            int curSold = Math.max(lastSold, lastBuy + A[i]);
            lastBuy = curBuy;
            lastSold = curSold;
        }
        
        return lastSold;
    }

}
