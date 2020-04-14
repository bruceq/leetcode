package com.it.bruce.leetcode._1281.整数的各位积和之差;

public class Main {
    public static void main(String[] args) {
        Main main=new Main();
        System.out.println(main.subtractProductAndSum(4421));
    }
    public int subtractProductAndSum(int n) {
        int multy = 1;
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            multy *= num;
            sum += num;
        }
        return multy - sum;
    }
}
