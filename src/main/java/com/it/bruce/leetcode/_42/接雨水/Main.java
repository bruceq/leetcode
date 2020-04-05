package com.it.bruce.leetcode._42.接雨水;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] height = {2, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {2, 0, 2};
        System.out.println(main.trap(height));
    }
//    public int trap(int[] height) {
//        int sum = 0;
//        int max = getMax(height);//找到最大的高度，以便遍历。
//        for (int i = 1; i <= max; i++) {
//            boolean isStart = false; //标记是否开始更新 temp
//            int temp_sum = 0;
//            for (int j = 0; j < height.length; j++) {
//                if (isStart && height[j] < i) {
//                    temp_sum++;
//                }
//                if (height[j] >= i) {
//                    sum = sum + temp_sum;
//                    temp_sum = 0;
//                    isStart = true;
//                }
//            }
//        }
//        return sum;
//    }
//    private int getMax(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] > max) {
//                max = height[i];
//            }
//        }
//        return max;
//    }

//    public int trap(int[] height) {
//        int sum = 0;
//        Stack<Integer> stack = new Stack<>();
//        int current = 0;
//        while (current < height.length) {
//            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
//            while (!stack.empty() && height[current] > height[stack.peek()]) {
//                int h = height[stack.peek()]; //取出要出栈的元素
//                stack.pop(); //出栈
//                if (stack.empty()) { // 栈空就出去
//                    break;
//                }
//                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
//                int min = Math.min(height[stack.peek()], height[current]);
//                sum = sum + distance * (min - h);
//            }
//            stack.push(current); //当前指向的墙入栈
//            current++; //指针后移
//        }
//        return sum;
//    }

//    public int trap(int[] height) {
//        int sum = 0;
//        int max_left = 0;
//        int max_right = 0;
//        int left = 1;
//        int right = height.length - 2; // 加右指针进去
//        for (int i = 1; i < height.length - 1; i++) {
//            //从左到右更
//            if (height[left - 1] < height[right + 1]) {
//                max_left = Math.max(max_left, height[left - 1]);
//                int min = max_left;
//                if (min > height[left]) {
//                    sum = sum + (min - height[left]);
//                }
//                left++;
//                //从右到左更
//            } else {
//                max_right = Math.max(max_right, height[right + 1]);
//                int min = max_right;
//                if (min > height[right]) {
//                    sum = sum + (min - height[right]);
//                }
//                right--;
//            }
//        }
//        return sum;
//    }

//    public int trap(int[] height) {
//        int sum = 0;
//        int max_left = 0;
//        int[] max_right = new int[height.length];
//        for (int i = height.length - 2; i >= 0; i--) {
//            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
//        }
//        for (int i = 1; i < height.length - 1; i++) {
//            max_left = Math.max(max_left, height[i - 1]);
//            int min = Math.min(max_left, max_right[i]);
//            if (min > height[i]) {
//                sum = sum + (min - height[i]);
//            }
//        }
//        return sum;
//    }

    public int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


}
