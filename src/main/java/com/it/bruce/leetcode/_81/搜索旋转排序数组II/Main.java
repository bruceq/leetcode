package com.it.bruce.leetcode._81.搜索旋转排序数组II;

public class Main {
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
