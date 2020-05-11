package com.it.bruce.leetcode.李小龙;

import java.util.Scanner;
import java.util.Stack;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(isValid(s));
        }
    }

    public static int isValid(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '<') {
                    stack.push(s.charAt(i));
                } else {
                    if ((s.charAt(i) == ')' && stack.peek() == '(') ||
                            (s.charAt(i) == ']' && stack.peek() == '[') ||
                            (s.charAt(i) == '>' && stack.peek() == '<')) {
                        stack.pop();
                    } else {
                        return 0;
                    }
                }
            }
        }
        return stack.empty() ? 1 : 0;
    }
}
