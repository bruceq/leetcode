package com.it.bruce.leetcode.sort.quickSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 432, 2, 31, 5, 234, 12};
        quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    /**
     * 快速排序思路：
     * 在一组元素中，选取一个基准值，把大于基准值的元素放到右侧，小于基准值的元素放到左侧，重复操作直到完成排序。
     * <p>
     * 使用方法：
     * 1、找基准值，并设置首、尾标识（low、high）
     * 2、从后半部分开始，当扫描值大于基准值时就让high-1，如果比基准值小，则把high位置的值赋值给low
     * 3、然后从前向后臊面，如果扫描至小于low则low+1，如果大于基准值则将low位置的值付给high位置
     * 4、递归操作
     *
     * @param arr
     * @param low
     * @param high
     */
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

    /**
     * 返回排序后基准值的位置
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
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
