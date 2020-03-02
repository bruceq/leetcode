package com.it.bruce.leetcode._75.SortColors;

public class Main {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        // 指定递归退出条件
        if (low < high) {
            // 获取排序后基准值的位置
            int pivot = partition(arr, low, high);
            // 对小于基准值的元素再次进行排序
            quickSort(arr, low, pivot - 1);
            // 对大于基准值的元素再次进行排序
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotKey = arr[low];
        while (low < high) {
            // 当尾部元素大于基准值时high-1
            while (low < high & arr[high] >= pivotKey) {
                high--;
            }
            // 否则将尾部元素赋值给首部位置
            arr[low] = arr[high];
            // 当首部元素小于基准值时low+1
            while (low < high && arr[low] <= pivotKey) {
                low++;
            }
            // 否则将首部元素赋值给尾部位置
            arr[high] = arr[low];
        }
        // 将基准值插入到首部和尾部中间位置
        arr[low] = pivotKey;
        // 返回基准值的位置
        return low;
    }
}
