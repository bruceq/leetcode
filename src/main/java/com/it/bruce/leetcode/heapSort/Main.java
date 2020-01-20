package com.it.bruce.leetcode.heapSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.toIntExact(Math.round(Math.random() * 1000));
        }
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void HeapSort(int[] arr) {
        int i;
        for (i = arr.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(arr, i, arr.length);
        }
        for (i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            HeapAdjust(arr, 0, i);
        }
    }

    private static void HeapAdjust(int[] arr, int s, int m) {
        int temp;
        temp = arr[s];
        int index = 2 * s + 1;
        while (index < m) {
            if (index + 1 < m) {
                if (arr[index] < arr[index + 1]) {
                    index++;
                }
            }
            if (arr[index] > temp) {
                arr[s] = arr[index];
                s = index;
                index = 2 * s + 1;
            } else {
                break;
            }
        }
        arr[s] = temp;
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
