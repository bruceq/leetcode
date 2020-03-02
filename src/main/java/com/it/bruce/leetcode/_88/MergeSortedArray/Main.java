package com.it.bruce.leetcode._88.MergeSortedArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 3, 4};
        main.merge(nums1, 3, nums2, 3);
        List<Integer> collect = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        collect.forEach(i -> System.out.print(i + " "));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            nums1[m + n - 1] = (m == 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
        }
    }
}
