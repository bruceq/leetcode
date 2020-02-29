package com.it.bruce.leetcode._55.JumpGame;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {1};
        int[] nums4 = {2, 0};
        int[] nums5 = {0, 2, 3};
        System.out.println(main.canJump(nums1));
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int i = 0; i <= index; i++) {
            if (index < i + nums[i]) {
                index = i + nums[i];
            }
            if (index >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
