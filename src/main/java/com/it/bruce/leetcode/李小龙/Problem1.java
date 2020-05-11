package com.it.bruce.leetcode.李小龙;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strs = sc.next().split("");
            int year = Integer.parseInt(strs[0]);
            int month = Integer.parseInt(strs[1]);
            int date = Integer.parseInt(strs[2]);
            int day = 0;
            if (year <= 0 || month <= 0 || month > 12 || date <= 0 || date > 31) {
                System.out.println(-1);
                break;
            }
            for (int i = 1; i < month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                    day += 31;
                } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                    day += 30;
                } else if (i == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
                    day += 29;
                } else {
                    day += 28;
                }
            }
            day += date;
            System.out.println(day);
        }
    }

}
