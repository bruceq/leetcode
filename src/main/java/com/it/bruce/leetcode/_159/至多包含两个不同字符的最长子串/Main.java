package com.it.bruce.leetcode._159.至多包含两个不同字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(main.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            String strj = s.substring(j, j + 1);
            if (map.get(strj) == null) {
                map.put(strj, 1);
            } else {
                map.put(strj, map.get(strj) + 1);
            }
            j++;
            while (map.size() > 2) {
                String stri = s.substring(i, i + 1);
                if (map.get(stri) - 1 == 0) {
                    map.remove(stri);
                } else {
                    map.put(stri, map.get(stri) - 1);
                }
                i++;
            }
            max = Math.max(j - i, max);
        }
        return max;
    }
}
