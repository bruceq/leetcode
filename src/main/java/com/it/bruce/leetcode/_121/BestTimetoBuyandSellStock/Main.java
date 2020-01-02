package com.it.bruce.leetcode._121.BestTimetoBuyandSellStock;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Main main = new Main();
        System.out.println(main.maxProfit(prices));
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * <p>
     * Note that you cannot sell a stock before you buy one.
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        if (prices.length < 2) {
//            return 0;
//        }
//        int[] result = new int[prices.length];
//        Arrays.fill(result, 0);
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = 0; j < i; j++) {
//                int temp = prices[i] - prices[j];
//                if (temp > 0 && result[i] < temp) {
//                    result[i] = temp;
//                }
//            }
//        }
//        Arrays.sort(result);
//        return result[result.length - 1];
//    }
    public int maxProfit(int[] prices) {
        int ans = 0;
        if (prices.length == 0) {
            return ans;
        }
        int bought = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bought) {
                if (ans < (prices[i] - bought)) {
                    ans = prices[i] - bought;
                }
            } else {
                bought = prices[i];
            }
        }
        return ans;
    }
}
