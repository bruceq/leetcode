package com.it.bruce.leetcode._246.中心对称数;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.isStrobogrammatic("69"));
//        System.out.println(main.isStrobogrammatic("88"));
//        System.out.println(main.isStrobogrammatic("6922"));
        System.out.println(main.isStrobogrammatic("3"));
        System.out.println(main.isStrobogrammatic("25"));
    }

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            if (map.get(num.charAt(i)) == null || map.get(num.charAt(i)) != num.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
