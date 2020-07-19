package com.it.bruce.leetcode._139.单词拆分;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> worddict = new ArrayList<>();
        worddict.add("a");
        worddict.add("aa");
        worddict.add("aaa");
        worddict.add("aaaa");
        worddict.add("aaaaa");
        worddict.add("aaaaaa");
        worddict.add("aaaaaaa");
        worddict.add("aaaaaaaa");
        worddict.add("aaaaaaaaa");
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", worddict));
    }
//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaa"]
    boolean res = false;

    public boolean wordBreak(String s, List<String> wordDict) {
        dfs(s, wordDict);
        return res;
    }

    private void dfs(String s, List<String> wordDict) {
        if (s.length() == 0 || res == true) {
            res = true;
            return;
        }
        if (!res) {
            for (int i = 1; i <= s.length(); i++) {
                if (wordDict.contains(s.substring(0, i))) {
                    dfs(s.substring(i), wordDict);
                }
            }
        }
    }


}
