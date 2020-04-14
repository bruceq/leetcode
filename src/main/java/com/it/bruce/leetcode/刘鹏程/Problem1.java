package com.it.bruce.leetcode.刘鹏程;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        one = one.replace(" ", "").replace("\t", "");
        String two = scanner.nextLine();
        int count = 0;
        if (one.isEmpty() || two.isEmpty()) {
            System.out.println(count);
        } else {
            for (int i = 0; i <= one.length() - two.length(); i++) {
                if (one.substring(i, i + two.length()).equals(two)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
