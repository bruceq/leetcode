package com.it.bruce.leetcode.sort.insertSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序：
     * 1、从待排序元素中的第二个元素开始进行遍历
     * 2、记录当前元素作为临时变量
     * 3、判断当前元素前的元素是否小于当前元素，小于则不处理，否则把当前元素和前一元素进行互换
     * 4、进行遍历，直到当前元素前的所有元素都已经排好序为止
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int leftindex = i - 1;
            while (leftindex >= 0 && arr[leftindex] > temp) {
                arr[leftindex + 1] = arr[leftindex];
                leftindex--;
            }
            arr[leftindex + 1] = temp;
        }
    }
}
