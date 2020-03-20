package com.it.bruce.leetcode.Inteview;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] data = {1100, 1100, 29, 1, 387, 12, 867};
        radixSort(data, 10, 4);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private static void radixSort(int[] data, int radix, int d) {
        int[] tem = new int[data.length];
        int[] buckets = new int[radix];
        int rate = 1;
        for (int i = 0; i < d; i++) {
            Arrays.fill(buckets, 0);
            System.arraycopy(data, 0, tem, 0, data.length);
            for (int j = 0; j < data.length; j++) {
                int subkey = (tem[j] / rate) % radix;
                buckets[subkey]++;
            }
            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }
            for (int m = data.length - 1; m >= 0; m--) {
                int subkey = (tem[m] / rate) % radix;
                data[--buckets[subkey]] = tem[m];
            }
            // for (int m = 0; m < data.length; m++) {
            //     int subkey = (tem[m] / rate) % radix;
            //     data[--buckets[subkey]] = tem[m];
            // }
            // System.out.print("第" + i + "次遍历结果：");
            // for (int a = 0; a < data.length; a++) {
            //     System.out.print(data[a] + " ");
            // }
            // System.out.println();
            rate *= radix;
        }
    }
}
