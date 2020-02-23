package com.it.bruce.leetcode._53.MaximumSubarray;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(main.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        // 从第一个数开始循环
        // 每次循环记录已循环过的数的和
        // 直到循环结束，返回最大值
        int max = Integer.MIN_VALUE;
        int tem = 0;
        for (int j = 0; j < nums.length; j++) {
            if (tem < 0) {
                tem = nums[j];
            } else
                tem += nums[j];
            if (tem > max) {
                max = tem;
            }
        }
        return max;
    }
}
