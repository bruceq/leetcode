package com.it.bruce.leetcode._47.PermutationsII;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 2, 1};
        System.out.println(main.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        boolean[] used = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, used);
        return new ArrayList<>(list);
    }

    private void backtrack(Set<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
