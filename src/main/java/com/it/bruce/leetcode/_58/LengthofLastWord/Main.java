package com.it.bruce.leetcode._58.LengthofLastWord;

public class Main {
    public static void main(String[] args) {
        Main main= new Main();
        System.out.println(main.lengthOfLastWord("Hello World"));
    }
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        if (s1.length == 0)
            return 0;
        return s1[s1.length - 1].length();
    }
}
