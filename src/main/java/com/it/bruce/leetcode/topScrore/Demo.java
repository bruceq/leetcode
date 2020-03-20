package com.it.bruce.leetcode.topScrore;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // int[] nums = {2, -5, -10, 10};
        // int[] nums = {2,-2};
        int[] nums = {-2,2};
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 正数向右移动
            if (nums[i] > 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        if (compareAndSwapInts(nums, i, j)) break;
                    }
                }
            } else if (nums[i] < 0) { // 负数向左移动
                for (int j = i; j > 0; j--) {
                    if (nums[i] < nums[j]) {
                        if (compareAndSwapInts(nums, i, j)) break;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        System.out.println(list);
    }

    private static boolean compareAndSwapInts(int[] nums, int i, int j) {
        if (Math.abs(nums[i]) < Math.abs(nums[j])) {
            nums[i] = 0;
            return true;
        } else if (Math.abs(nums[i]) == Math.abs(nums[j])) {
            nums[i] = 0;
            nums[j] = 0;
            return true;
        } else {
            swap(i, j, nums);
        }
        return false;
    }

    private static void swap(int i, int j, int[] nums) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
