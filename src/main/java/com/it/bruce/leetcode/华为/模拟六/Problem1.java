package com.it.bruce.leetcode.华为.模拟六;

import com.it.bruce.leetcode.华为.模拟一.Problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Problem1 {

    public static void main(String[] args) {
        Problem1 main = new Problem1();
        System.out.println(main.isAnagram("aacc", "ccac"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        boolean flag = true;
        for (char c : t.toCharArray()) {
            if (map.get(c) == null || map.get(c) == 0) {
                flag = false;
                break;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return flag;
    }
}
