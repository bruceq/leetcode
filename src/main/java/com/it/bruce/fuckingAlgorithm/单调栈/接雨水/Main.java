package com.it.bruce.fuckingAlgorithm.单调栈.接雨水;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Main main = new Main();
        System.out.println(main.trap(height));

    }

    public int trap(int[] height) {
//        int sum = 0;
//        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
//        for (int i = 1; i < height.length - 1; i++) {
//            int max_left = 0;
//            //找出左边最高
//            for (int j = i - 1; j >= 0; j--) {
//                if (height[j] > max_left) {
//                    max_left = height[j];
//                }
//            }
//            int max_right = 0;
//            //找出右边最高
//            for (int j = i + 1; j < height.length; j++) {
//                if (height[j] > max_right) {
//                    max_right = height[j];
//                }
//            }
//            //找出两端较小的
//            int min = Math.min(max_left, max_right);
//            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
//            if (min > height[i]) {
//                sum = sum + (min - height[i]);
//            }
//        }
//        return sum;

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;

    }
}
