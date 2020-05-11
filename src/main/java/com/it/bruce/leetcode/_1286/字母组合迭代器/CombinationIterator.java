package com.it.bruce.leetcode._1286.字母组合迭代器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CombinationIterator {
    public static void main(String[] args) {
        CombinationIterator com = new CombinationIterator("ace", 2);
//        System.out.println(com.next());
//        System.out.println(com.hasNext());
//        System.out.println(com.next());
//        System.out.println(com.hasNext());
//        System.out.println(com.next());
//        System.out.println(com.hasNext());
    }

//    List<List<Character>> result = new ArrayList<>();
//
//    public CombinationIterator(String characters, int combinationLength) {
//        char[] chars = characters.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        int len = chars.length;
//
//        backtracedfs(result, 0, stack, chars, len, combinationLength);
//        System.out.println(result);
//    }
//
//    private void backtracedfs(List<List<Character>> result, int index, Stack<Character> stack, char[] chars, int len,
//                              int limit) {
//
//        if (stack.size() == limit) {
//            result.add(new ArrayList<>(stack));
//            return;
//        }
//
//        for (int i = index; i < len; i++) {
//            stack.add(chars[i]);
//            backtracedfs(result, i + 1, stack, chars, len, limit);
//            stack.pop();
//        }
//
//    }
//
//    public String next() {
//        if (result.size() > 0) {
//            List<Character> temp = result.remove(0);
//            StringBuilder builder = new StringBuilder();
//            for (Character c : temp) {
//                builder.append(c);
//            }
//            return builder.toString();
//        }
//
//        return null;
//    }
//
//    public boolean hasNext() {
//        return result.size() != 0;
//    }

    List<List<Character>> list = new ArrayList<>();

    public CombinationIterator(String characters, int combinationLength) {
        backtrack(characters, list, new ArrayList<>(), combinationLength, 0);
        System.out.println(list);
    }

    private void backtrack(String characters, List<List<Character>> list, List<Character> tempList, int length, int start) {
        ArrayList<Character> charTemp = new ArrayList<>(tempList);
        if (charTemp.size() == length) {
            list.add(charTemp);
        }
        for (int i = start; i < characters.length(); i++) {
            tempList.add(characters.charAt(i));
            backtrack(characters, list, tempList, length, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public String next() {
        String res = "";
        if (!list.isEmpty()) {
            List<Character> characters = list.get(0);
            for (char c : characters) {
                res += String.valueOf(c);
            }
            list.remove(0);
        }
        return res;
    }

    public boolean hasNext() {
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }
}
