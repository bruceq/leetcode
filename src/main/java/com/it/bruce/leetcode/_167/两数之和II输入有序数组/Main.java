package com.it.bruce.leetcode._167.两数之和II输入有序数组;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int n : numbers) {
            map.put(n, index);
            index++;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[]{i + 1, map.get(target - numbers[i])};
            }
        }
        return new int[2];
    }
}
