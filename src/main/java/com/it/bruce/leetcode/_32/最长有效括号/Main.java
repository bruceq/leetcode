package com.it.bruce.leetcode._32.最长有效括号;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.longestValidParentheses("(()"));
//        System.out.println(main.longestValidParentheses(")()())"));
//        System.out.println(main.longestValidParentheses("()(()"));
//        System.out.println(main.longestValidParentheses("()(()()(()"));
//        System.out.println(main.longestValidParentheses(")("));
        System.out.println(main.longestValidParentheses(")()())()()("));
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                //下标入栈
                stack.push(i);
            } else {
                // 出栈
                stack.pop();
                // 看栈顶是否为空，为空的话就不能作差了
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    // i - 栈顶，获得档期有效括号长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
