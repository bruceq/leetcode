package com.it.bruce.leetcode._1.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 4, 5, 7, 8};
        int[] result = main.twoSum(nums, 9);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * Time:O(n)
     * Space:O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
