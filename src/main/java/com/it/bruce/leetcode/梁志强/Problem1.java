package com.it.bruce.leetcode.梁志强;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num < 2) {
            System.out.println(false);
            return;
        }
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
