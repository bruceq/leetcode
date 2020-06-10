package com.it.bruce.leetcode._126.单词接龙II;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList() {
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
                add("cog");
            }
        };
        Main main = new Main();
        main.findLadders(beginWord, endWord, wordList);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() == 0 || beginWord.equals("") || endWord.length() == 0 || endWord.equals("") || wordList.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> list = new ArrayList<>();
        backtrack(beginWord, endWord, wordList, list, new ArrayList<>());
        return list;
    }

    private void backtrack(String beginWord, String endWord, List<String> wordList, List<List<String>> list, List<String> tempList) {
        tempList.add(beginWord);
        if (beginWord.equals(endWord)) {
            list.add(new ArrayList<>(tempList));
        }
        for (int n = 0; n < wordList.size(); n++) {
            int diff = 0;
            for (int i = 0; i < wordList.get(n).toCharArray().length; i++) {
                if (wordList.get(n).toCharArray()[i] != beginWord.toCharArray()[i]) {
                    diff++;
                }
            }
            if (diff == 1) {
                beginWord = wordList.get(n);
                String remove = wordList.remove(n);
                backtrack(beginWord, endWord, wordList, list, tempList);
                tempList.remove(tempList.size() - 1);
                wordList.add(remove);
//                break;
            }
        }
    }
}
