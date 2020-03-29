package com.it.bruce.leetcode._77.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.combine(10, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, k, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> templist, int n, int k, int start) {
        if (templist.size() == k) {
            list.add(new ArrayList<>(templist));
        }
        for (int i = start; i < n; i++) {
            templist.add(i + 1);
            backtrack(list, templist, n, k, i + 1);
            templist.remove(templist.size() - 1);
        }
    }
}
