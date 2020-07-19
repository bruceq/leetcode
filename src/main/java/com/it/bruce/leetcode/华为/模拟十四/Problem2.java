package com.it.bruce.leetcode.华为.模拟十四;

import com.it.bruce.leetcode._252.会议室.Main;
import com.it.bruce.leetcode.华为.模拟一.Problem;

import java.util.ArrayList;
import java.util.List;


/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 main = new Problem2();
        System.out.println(main.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String left, int count1, int count2, int n) {
        if (count1 > n || count2 > n) {
            return;
        }
        if (count1 == n && count2 == n) {
            list.add(left);
        }
        if (count1 >= count2) {
            String right = new String(left);
            backtrack(list, left + "(", count1 + 1, count2, n);
            backtrack(list, right + ")", count1, count2 + 1, n);
        }
    }
}
