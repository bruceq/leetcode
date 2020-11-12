package com.it.bruce.leetcode.倒水;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.exam(new int[]{3, 1, 5, 10}, 3);
//        main.exam(new int[]{10, 10, 1, 10, 11}, 2);

    }

    public int exam(int[] water, int cnt) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int w : water) {
            if (map.get(w) == null) {
                map.put(w, 1);
            } else {
                map.put(w, map.get(w) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == cnt) {
                return 0;
            }
        }
        Arrays.sort(water);
        int left = 0;
        int right = cnt - 2;
        int res = Integer.MAX_VALUE;
        for (int i = cnt - 1; i < water.length; i++) {
            int tmp = 0;
            while (right < i) {
                for (int j = left; j <= right; j++) {
                    tmp += water[i] - water[j];
                }
                left++;
                right++;
                res = Math.min(res, tmp);
            }
        }
        return res;
    }
}
