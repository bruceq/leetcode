package com.it.bruce.leetcode._50.Pow;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.myPow(2.00000, -2));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1.;
        double res = myPow(x, n / 2);
        return n % 2 == 0 ? res * res : n < 0 ? res * res * (1 / x) : res * res * x;
    }
}
