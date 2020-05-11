package com.it.bruce.leetcode.华为.模拟六;

import com.it.bruce.leetcode.华为.模拟一.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * <p>
 * 提示：
 * <p>
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 */
public class Problem3 {

    public static void main(String[] args) {
        Problem3 main = new Problem3();
        System.out.println(main.scoreOfParentheses("(()(()))"));
    }

    public int scoreOfParentheses(String S) {
        int score = 0;
        int length = S.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char temp = S.charAt(i);
            if (temp == '(')
                stack.add(temp);
            else {
                if (S.charAt(i - 1) == '(') {
                    score += Math.pow(2, stack.size() - 1);
                    stack.pop();
                } else {
                    stack.pop();
                }
            }

        }

        return score;
    }
}
