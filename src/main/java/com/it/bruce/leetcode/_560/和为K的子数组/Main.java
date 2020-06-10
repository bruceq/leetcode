package com.it.bruce.leetcode._560.和为K的子数组;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.subarraySum(new int[]{100, 1, 2, 3, 4}, 6));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
