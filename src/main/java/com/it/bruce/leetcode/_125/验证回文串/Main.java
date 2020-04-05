package com.it.bruce.leetcode._125.验证回文串;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(main.isPalindrome("race a car"));
        System.out.println(main.isPalindrome("0p"));
    }

    public boolean isPalindrome(String s) {
        String[] strs = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (str.matches("[a-z0-9]")) {
                sb.append(str);
            }
        }
        String str = sb.toString();
        String str_rerv = sb.reverse().toString();
        return str.equals(str_rerv);
    }
}
