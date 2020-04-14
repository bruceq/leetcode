package com.it.bruce.leetcode._面试题搜索旋转数组;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
    }

    public int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
