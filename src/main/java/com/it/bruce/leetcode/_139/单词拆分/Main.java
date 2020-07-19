package com.it.bruce.leetcode._139.单词拆分;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
//        System.out.println(wordBreak("catsandog", wordDict));

//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        wordBreak("leetcode", wordDict);

//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("apple");
//        wordDict.add("pen");
//        wordBreak("applepenapple", wordDict);
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        // 队列中加上0
        queue.add(0);
        // 队列不空则循环判断
        while (!queue.isEmpty()) {
            // 队首元素出队，并将指针指向该元素
            int start = queue.remove();
            // 如果当前元素没有被访问
            if (visited[start] == 0) {
                // 对单词从指针标记的位置开始，向后遍历
                for (int end = start + 1; end <= s.length(); end++) {
                    // 如果单词列表中包含截取的字符串
                    if (wordDictSet.contains(s.substring(start, end))) {
                        // 当前end入队
                        queue.add(end);
                        System.out.println(s.substring(start, end));
                        // 最后一个符合规则的单词遍历完正好用完字符串中所有字符
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                // 第start个字符被访问过
                visited[start] = 1;
            }
        }
        return false;
    }

}
