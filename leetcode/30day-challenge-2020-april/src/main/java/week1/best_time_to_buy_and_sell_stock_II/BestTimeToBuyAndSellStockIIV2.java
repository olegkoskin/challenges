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
public class BestTimeToBuyAndSellStockIIV2 {

    /**
     * Recursion approach. Ver-y-y-y long.
     *
     * @param prices prices
     * @return max profit
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        Transaction[][] transactions = new Transaction[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int profit = prices[j] - prices[i];
                transactions[i][j] = new Transaction(i, j, profit);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf("|%15s|", transactions[i][j]);
            }
            System.out.println();

        }

        return chain(transactions, 0, 0, length);
    }

    private int chain(Transaction[][] transactions, int i0, int j0, int length) {
        int maxProfit = 0;
        for (int i = i0; i < length; i++) {
            int profit = 0;
            for (int j = j0 + 1; j < length; j++) {
                Transaction cur = transactions[i][j];
                if (cur == null) {
                    continue;
                }
                profit = cur.profit + chain(transactions, cur.sellDay + 1, cur.sellDay + 1, length);
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static class Transaction {

        private int buyDay;
        private int sellDay;
        private int profit;

        public Transaction(int buyDay, int sellDay, int profit) {
            this.buyDay = buyDay;
            this.sellDay = sellDay;
            this.profit = profit;
        }

        public int getBuyDay() {
            return buyDay;
        }

        public int getSellDay() {
            return sellDay;
        }

        public int getProfit() {
            return profit;
        }

        @Override
        public String toString() {
            return "T{" + buyDay + " -> " + sellDay + " = " + profit + "}";
        }
    }

}
