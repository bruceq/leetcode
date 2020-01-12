package com.it.bruce.leetcode.sort.bubbleSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.toIntExact(Math.round(Math.random() * 1000));
        }
        bubbleSortII(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 常见冒泡排序
     *
     * @param arr
     * 
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序优化
     *
     * @param arr
     */
    private static void bubbleSortII(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
