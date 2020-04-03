package com.it.bruce.leetcode._547.FriendCircles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] M = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        System.out.println(main.findCircleNum(M));
    }

    class UnionFind {
        private int count = 0;
        private int[] parent, rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int count() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }

//    public int findCircleNum(int[][] M) {
//        List<Set<Integer>> circle = new ArrayList<>();
//        for (int i = 0; i < M.length; i++) {
//            for (int j = 0; j < M.length; j++) {
//                if (i != j) {
//                    if (M[i][j] == 1) {
//                        boolean isNotExist = true;
//                        for (Set<Integer> set : circle) {
//                            if (set.contains(i) || set.contains(j)) {
//                                set.add(i);
//                                set.add(j);
//                                isNotExist = false;
//                                break;
//                            }
//                        }
//                        if (isNotExist) {
//                            Set<Integer> friends = new HashSet<>();
//                            friends.add(i);
//                            friends.add(j);
//                            circle.add(friends);
//                        }
//                    }
//                }
//            }
//        }
//        List<Set<Integer>> res = new ArrayList<>();
//        for (Set<Integer> set : circle) {
//            if (res.isEmpty()) {
//                res.add(set);
//            } else {
//                boolean isNotExist = true;
//                for (Set<Integer> s : res) {
//                    for (int i : set) {
//                        if (s.contains(i)) {
//                            s.addAll(set);
//                            isNotExist = false;
//                            break;
//                        }
//                    }
//                }
//                if (isNotExist) {
//                    res.add(set);
//                }
//            }
//        }
//        int inCircle = 0;
//        for (Set<Integer> c : res) {
//            inCircle += c.size();
//        }
//        return res.size() + M.length - inCircle;
//    }


}
