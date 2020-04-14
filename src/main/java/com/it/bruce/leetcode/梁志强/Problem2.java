package com.it.bruce.leetcode.梁志强;

import java.util.Scanner;

public class Problem2 {
//    public static void main(String[] args) {
//        double a = 500;
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()){
//            int num = Integer.parseInt(sc.nextLine());
//            if (num == 0) {
//                System.out.println(0);
//                continue;
//            }
//            if (num == 1) {
//                System.out.println(500);
//                continue;
//            }
//            double lang = 0;
//            for (int i = 2; i <= num; i++) {
//
//                lang += a;
//                a = a / 2;
//            }
//            System.out.println(lang + 500);
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            double height = 500;
            double path = 0;
            double x = 1;
            if (i == 1) {
                System.out.println(height);
                continue;
            } else {
                for (int n = 2; n <= i; n++) {
                    path += height * x;
                    x = x / 2;
                }
            }
            System.out.println(path + 500d);
        }
    }
}
