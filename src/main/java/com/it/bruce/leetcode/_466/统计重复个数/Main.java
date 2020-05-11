package com.it.bruce.leetcode._466.统计重复个数;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getMaxRepetitions("lovelive", 1000, "lovelive", 100));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        String str1 = "";
        for (int i = 0; i < n1; i++) {
            str1 += s1;
        }
        String str2 = "";
        for (int i = 0; i < n2; i++) {
            str2 += s2;
        }
        if (str2.length() > str1.length()) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < str1.length()) {
            if (j == str2.length()) {
                j = 0;
                count++;
            } else {
                while (j < str2.length() && i < str1.length()) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        i++;
                    }
                }
            }
        }
        return j == str2.length() ? count + 1 : count;
    }
}
