package com.it.bruce.leetcode._243.最短单词距离;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes", "makes"}, "coding", "makes"));
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                list.add(i);
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word2)) {
                for (int l : list) {
                    min = min > Math.abs(i - l) ? Math.abs(i - l) : min;
                }
            }
        }
        return min;
    }
}
