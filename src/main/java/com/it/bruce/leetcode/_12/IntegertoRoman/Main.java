package com.it.bruce.leetcode._12.IntegertoRoman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.intToRoman(4));
    }

    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    Map<Integer, String> map = new HashMap<>();

    public String intToRoman(int num) {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        String s = "";
        for (int i = 0; i < nums.length; i++) {
            while (num / nums[i] > 0) {
                s += map.get(nums[i]);
                num -= nums[i];
            }
        }
        return s;
    }
}
