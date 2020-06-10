package com.it.bruce.leetcode.华为.模拟十;

import com.it.bruce.leetcode.华为.模拟一.Problem;

import java.util.StringJoiner;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Problem1 {
    public static void main(String[] args) {
        String s = "fasd    dsfas0";
        Problem1 main = new Problem1();
        System.out.println(main.reverseWords(s));
    }

    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder reverse = str.reverse();
        String trim = reverse.toString().trim();
        String[] s1 = trim.split(" ");
        StringJoiner res = new StringJoiner(" ");
        for (String s2 : s1) {
            if (!s2.equals("")) {
                StringBuilder temp = new StringBuilder(s2);
                StringBuilder reverse1 = temp.reverse();
                res.add(reverse1);
            }
        }
        return res.toString();
    }
}
