package com.it.bruce.leetcode.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bruce");
        list.add("Qi");
        list.add("is");
        list.add("handsome");

        String result = list.stream()// 首先将列表转化为Stream流
                .filter(i -> !isNum(i))// 首先筛选出字母型字符串
                .filter(i -> i.length() >= 2)// 其次筛选出长度>=5的字符串
                // .map(i -> i.toLowerCase())// 字符串统一转小写
                .distinct()                 // 去重操作来一下
                // .sorted(Comparator.naturalOrder()) // 字符串排序来一下
                .collect(Collectors.joining("❤")); // 连词成句来一下，完美！
        System.out.println(result);
    }

    private static boolean isNum(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
