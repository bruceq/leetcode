package com.it.bruce.leetcode._70.ClimbingStairs;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.climbStairs(45));
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];
    }


}
