package com.it.bruce.leetcode._85.MaximalRectangle;

import java.util.Stack;

public class Main {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        // for each cell with value=1, we look upward (north), the number of continuous '1' is the height of cell
        int[] heights = new int[matrix[0].length];
        int maxArea = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            // 把堆栈中比heights[i]大的元素都pop出，并计算面积
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                // 面积计算公式：(i - 1-stack.peek() ) * heights[top])
                max = Math.max(max, (i - 1 - stack.peek()) * heights[top]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[top]);
        }
        return max;
    }
}
