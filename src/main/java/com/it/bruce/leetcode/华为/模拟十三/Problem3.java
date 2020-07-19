package com.it.bruce.leetcode.华为.模拟十三;

import com.it.bruce.leetcode.华为.模拟一.Problem;

public class Problem3 {
    public static void main(String[] args) {
        Problem3 main = new Problem3();
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};
        System.out.println(main.findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int tempi = i;
                int tempj = j;
                if (A[i] == B[j]) {
                    max = Math.max(max, 1);
                    while (tempi < A.length && tempj < B.length && A[tempi] == B[tempj]) {
                        tempi++;
                        tempj++;
                        max = Math.max(max, tempi - i);
                    }
                }
            }
        }
        return max;
    }
}
