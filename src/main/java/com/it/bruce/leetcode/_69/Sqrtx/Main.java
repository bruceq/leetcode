package com.it.bruce.leetcode._69.Sqrtx;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.mySqrt(8));
    }

    public int mySqrt(int x) {
        return Double.valueOf(Math.sqrt(x)).intValue();
    }
}
