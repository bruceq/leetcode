package com.it.bruce.leetcode.华为.模拟十三;

public class Problem2 {
    public static void main(String[] args) {
        Problem2 main = new Problem2();
        System.out.println(main.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            if (sum < s) {
                j++;
            } else {
                min = Math.min(min, j - i + 1);
            }
            while (i <= j && sum >= s) {
                sum -= nums[i];
                i++;
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                } else {
                    j++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
