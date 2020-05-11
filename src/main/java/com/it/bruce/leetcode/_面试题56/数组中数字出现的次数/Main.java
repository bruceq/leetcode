package com.it.bruce.leetcode._面试题56.数组中数字出现的次数;

import java.util.*;

public class Main {
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                index++;
            }
        }
        int[] res = new int[index];
        index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[index] = entry.getKey();
                index++;
            }
        }
        return res;
    }
}
