package com.it.bruce.leetcode.华为.模拟八;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Problem2 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            list.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append("(");
            backtrack(list, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (open > close) {
            cur.append(")");
            backtrack(list, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
