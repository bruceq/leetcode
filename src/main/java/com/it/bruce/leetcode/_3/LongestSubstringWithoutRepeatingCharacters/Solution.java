package com.it.bruce.leetcode._3.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        int max = 0;
        while (i <= j && i < s.length() && j < s.length()) {
            if (!set.contains(chars[j])) {
                set.add(chars[j]);
                j++;
            } else {
                set.remove(chars[i]);
                i++;
            }
            max = Math.max(j - i, max);
        }
        return max;
    }
}
