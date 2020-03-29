package com.it.bruce.leetcode._80.RemoveDuplicatesfromSortedArrayII;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(main.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int result = 1;
        int k = 1;
        int index = 1;
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1] && k == 2) {
                    continue;
                } else if (nums[i] == nums[i - 1]) {
                    k += 1;
                    result += 1;
                    index += 1;
                    nums[index - 1] = nums[i];
                } else {
                    result += 1;
                    k = 1;
                    index += 1;
                    nums[index - 1] = nums[i];
                }
            }
        }
        return result;
    }
}
