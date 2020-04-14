package com.it.bruce.leetcode._面试题左旋转字符串;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.reverseLeftWords("abcdefg", 2));
    }

    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length());
        return s2 + s1;
    }

}
