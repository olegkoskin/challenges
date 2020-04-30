package week1.best_time_to_buy_and_sell_stock_II;

/**
 * Best Time to Buy and Sell Stock II.
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you
 * buy again).
 * <p>
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * <p>
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * <p>
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockIIV3 {

    /**
     * Peak-valley pattern.
     *
     * @param prices prices
     * @return max profit
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;

        int[] a = new int[length + 1];
        for (int i = 0; i < length - 1; i++) {
            a[i] = prices[i + 1] - prices[i];
        }

        for (int i = length - 2; i >= 0; i--) {
            a[i] = Math.max(a[i + 1], Math.max(a[i], a[i + 1] + (prices[i + 1] - prices[i])));
        }

        return a[0];
    }

}
