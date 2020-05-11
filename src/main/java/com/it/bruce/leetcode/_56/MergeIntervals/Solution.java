package com.it.bruce.leetcode._56.MergeIntervals;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{1, 0, 1, 0}));
    }

    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return false;
        } else if (length == 1) {
            return true;
        } else if (nums[0] == 0) {
            return false;
        }
        boolean[] dp = new boolean[length];
        dp[0] = true;
        for (int n = 0; n < length - 1; n++) {
            int i1 = n + nums[n];
            for (int i = n; i <= i1; i++) {
                if (dp[n]) {
                    dp[i] = true;
                }
                if (dp[length - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
