package com.it.bruce.fuckingAlgorithm.滑动窗口.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "addbecocebanc";
        String t = "abc";
        Main main = new Main();
        System.out.println(main.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int match = 0;
        while (right < s.length()) {
            char c1 = s.toCharArray()[right];
            if (needs.get(c1) != null) {
                if (window.get(c1) == null) {
                    window.put(c1, 1);
                }
                if (window.get(c1) != null && window.get(c1) < needs.get(c1)) {
                    window.put(c1, window.get(c1) + 1);
                }
                if (window.get(c1) == needs.get(c1)) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.toCharArray()[left];
                if (needs.get(c2) != null) {
                    if (window.get(c2) != null) {
                        window.put(c2, window.get(c2) - 1);
                    }
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}