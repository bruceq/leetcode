package com.it.bruce.fuckingAlgorithm.单调栈.下一个暖和的天气;

import java.util.Stack;

/**
 * 给你一个数组 T = [73, 74, 75, 71, 69, 72, 76, 73]，这个数组存放的是近几天的天气气温（这气温是铁板烧？不是的，这里用的华氏度）。你返回一个数组，计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0 。
 * 举例：给你 T = [73, 74, 75, 71, 69, 72, 76, 73]，你返回 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 解释：第一天 73 华氏度，第二天 74 华氏度，比 73 大，所以对于第一天，只要等一天就能等到一个更暖和的气温。后面的同理。
 */
public class Main {
    private int[] dailyTemperatures(int[] t) {
        int res[] = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = t.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= t[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
