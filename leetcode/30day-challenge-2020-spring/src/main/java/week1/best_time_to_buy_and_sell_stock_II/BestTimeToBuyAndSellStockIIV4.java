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
public class BestTimeToBuyAndSellStockIIV4 {

    /**
     * The rule is: we cannot buy and sell the stock at the same time. So the best solution is finding the max
     * difference of prices in a long enough time, otherwise we will have some lose due to the rule. For example,
     * [2, 4, 6, 9](the max profit should be 9 - 2 = 7), if we make transaction every 2 days, then profit is
     * (4 - 2) + (9 - 6) = 5 and the lose comes from the profit between day 3 and day 2 due to the rule, i.e. 6 - 4 = 2.
     * For a common example [3, (2, 4, 6, 9), 4, (3, 4, 7)], the sum of the diff of prices in the parentheses
     * (longest ascending array) should be the solution: (9 - 2) + (7 - 3) = 11.
     * <p>
     * Thus the real algorithm should be: finding all the longest ascending array, then for each ascending sub-array,
     * calculate the last number - 1st number which is the maximum profit for this sub-array. Then add them together,
     * the total sum is the result.(Author's code is a good way to simplify the code!)
     *
     * @param prices prices
     * @return max profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int res = 0;
        int prev = 0; // start index of the longest ascending array
        for (int i = 1; i < n; i++) {
            // if it is ascending
            if (prices[i] >= prices[i - 1]) continue;
            if (prices[i] < prices[i - 1]) {
                res += prices[i - 1] - prices[prev]; // [prev, i - 1] is one longest ascending sub-array
                prev = i;
            }
        }

        res += prices[n - 1] - prices[prev];
        return res;
    }

}
