package com.it.bruce.leetcode.刘鹏程;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] people = new int[8];
        String[] res = new String[8];
        res[0] = "[12,13):";
        res[1] = "[13,14):";
        res[2] = "[14,15):";
        res[3] = "[15,16):";
        res[4] = "[16,17):";
        res[5] = "[17,18):";
        res[6] = "[18,19):";
        res[7] = "[19,20):";
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] time = s.split(",");
            if (!s.equals("-1,-1")) {
                int start = Integer.parseInt(time[0]);
                int end = Integer.parseInt(time[1]);
                for (int i = 0; i < end - start; i++) {
                    people[start - 12 + i]++;
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    res[i] = res[i] + people[i];
                    System.out.println(res[i]);
                }
            }
        }
    }
}
