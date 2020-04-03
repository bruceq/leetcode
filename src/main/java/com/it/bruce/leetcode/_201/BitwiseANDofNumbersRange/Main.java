package com.it.bruce.leetcode._201.BitwiseANDofNumbersRange;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.rangeBitwiseAnd(5, 7));
        System.out.println(1 << 31);
    }

    public int rangeBitwiseAnd(int m, int n) {
        int diffBits = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            diffBits++;
        }
        return n << diffBits;
    }
}
