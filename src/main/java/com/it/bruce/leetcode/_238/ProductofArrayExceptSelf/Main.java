package com.it.bruce.leetcode._238.ProductofArrayExceptSelf;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 2, 3, 4};
        int[] ints = main.productExceptSelf(nums);
        Arrays.stream(ints).forEach(i -> System.out.print(i + " "));
    }

    /**
     * 1、创建一个新的数组
     * 2、第一遍遍历求当前元素左边的所有数乘积
     * 3、第二遍遍历使用第一遍的结果乘以当前元素右边的所有元素的乘积
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
