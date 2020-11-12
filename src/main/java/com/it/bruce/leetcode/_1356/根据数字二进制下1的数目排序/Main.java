package com.it.bruce.leetcode._1356.根据数字二进制下1的数目排序;

import java.util.*;

public class Main {
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            bit[i] = getBit(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bit[o1] != bit[o2]) {
                    return bit[o1] - bit[o2];
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int getBit(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x = x / 2;
        }
        return res;
    }
}
