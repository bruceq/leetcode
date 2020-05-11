package com.it.bruce.leetcode.华为.模拟五;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 main = new Problem2();
        System.out.println(main.getPermutation(3, 3));
    }

    public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i * fact[i - 1];
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int ind = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
//    public String getPermutation(int n, int k) {
//        List<List<Integer>> list = new ArrayList<>();
//        backtrack(list, new ArrayList<>(),  n);
//        String res = "";
//        for (int i : list.get(k - 1)) {
//            res += String.valueOf(i);
//        }
//        return res;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList,int n) {
//        if (tempList.size() == n) {
//            list.add(new ArrayList<>(tempList));
//        }
//        for (int i = 1; i <= n; i++) {
//            if (tempList.contains(i)) {
//                continue;
//            }
//            tempList.add(i);
//            backtrack(list, tempList,n);
//            tempList.remove(tempList.size() - 1);
//        }
//    }
}
