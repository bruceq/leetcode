package com.it.bruce.leetcode._746.MinCostClimbingStairs;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(main.minCostClimbingStairs(cost));
    }

    /**
     * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
     * <p>
     * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
     * <p>
     * Example 1:
     * Input: cost = [10, 15, 20]
     * Output: 15
     * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     * Example 2:
     * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * Output: 6
     * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length];
        if (cost.length == 0) {
            return 0;
        }
        for (int i = 0; i < cost.length; i++) {
            if (i == 0 || i == 1) {
                result[i] = cost[i];
            } else {
                result[i] = cost[i] + Math.min(result[i - 1], result[i - 2]);
            }
        }
        return Math.min(result[cost.length-2], result[cost.length - 1]);
    }
}
