package com.it.bruce.leetcode.sort.mergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 56, 2, 13, 54, 23, 1};
        //mergeSort(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        // 使用非递归方式实现归并排序
        int len = arr.length;
        int k = 1;
        while (k < len) {
            mergePass(arr, k, len);
            k *= 2;
        }
    }

    private static void mergePass(int[] arr, int k, int n) {
        int i = 0;
        // 从前往后走，将2个长度为k的子序列合并为1个
        while (i < n - 2 * k + 1) {
            merge(arr, i, i + k - 1, i + 2 * k - 1);
            i += 2 * k;
        }
        // 这段代码保证了，讲那些落单的长度不足两两merge的部分和前面merge起来
        if (i < n - k) {
            merge(arr, i, i + k - 1, n - 1);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        // p1是左半边指针
        int p1 = left;
        // p2是右半边指针
        int p2 = mid + 1;
        // 合并后数组指针
        int k = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            temp[k++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[k++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
}
