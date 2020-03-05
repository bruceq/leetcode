package com.it.bruce.leetcode._122.BestTimetoBuyandSellStockII;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(main.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0)
                max += prices[i + 1] - prices[i];
        }
        return max;
    }
}
