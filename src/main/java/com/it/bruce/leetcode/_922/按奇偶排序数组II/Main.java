package com.it.bruce.leetcode._922.按奇偶排序数组II;

public class Main {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int indexA = 0;
        int indexB = 1;
        for (int i = 0; i < len; i++) {
            if (A[i] % 2 == 0) {
                res[indexA] = A[i];
                indexA = indexA + 2;
            } else {
                res[indexB] = A[i];
                indexB = indexB + 2;
            }
        }
        return res;
    }
}
