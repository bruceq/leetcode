package com.it.bruce.fuckingAlgorithm.单调栈.找出下一个最大数;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 5, 4, 3};
        Main main = new Main();
        System.out.println(main.nextGreaterElement(nums));
    }

    private int[] nextGreaterElement(int[] nums) {
        int[] nextGreat = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // 从后向前扫描
        for (int i = nums.length - 1; i >= 0; i--) {
            // 如果栈中的元素不大于当前元素，则将栈中最后一个元素弹出
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            // 栈顶元素为比当前元素大的最近的元素
            nextGreat[i] = stack.isEmpty() ? -1 : stack.peek();
            // stack中存放的比当前数大的元素
            stack.push(nums[i]);
        }
        return nextGreat;
    }
}
