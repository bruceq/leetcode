package com.it.bruce.leetcode._49.GroupAnagrams;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(main.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> maps = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!maps.containsKey(key)) {
                maps.put(key, new ArrayList<>());
            }
            maps.get(key).add(s);
        }
        return new ArrayList<>(maps.values());
    }
}
