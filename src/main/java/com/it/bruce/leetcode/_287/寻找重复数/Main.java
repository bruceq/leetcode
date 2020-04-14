package com.it.bruce.leetcode._287.寻找重复数;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int i = 0, j = length - 1;
        Arrays.sort(nums);
        int res = 0;
        while (i < j) {
            if (i < length - 1 && nums[i] == nums[i + 1]) {
                res = nums[i];
                break;
            }
            if (j >= 1 && nums[j] == nums[j - 1]) {
                res = nums[j];
                break;
            }
            i++;
            j--;
        }
        return res;
    }
}
