package com.it.bruce.leetcode._209.MinimumSizeSubarraySum;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(main.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }


        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
