package com.it.bruce.leetcode._66.PlusOne;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] digits = {1, 2, 3};
        System.out.println(main.plusOne(digits));
    }

    public int[] plusOne(int[] digits) {
        String tem = "";
        for (int i : digits) {
            tem += i;
        }
        BigInteger num = new BigInteger(tem);
        num = num.add(new BigInteger("1"));
        String s = String.valueOf(num);
        String[] split = s.split("");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }
}
