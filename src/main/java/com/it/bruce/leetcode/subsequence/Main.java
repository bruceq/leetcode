package com.it.bruce.leetcode.subsequence;

public class Main {
    /**
     * 给出两个字符串s1和s2，判断s1和s2最长的重复部分有多长
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(theLongestSubSequence("111111111111111111111111114344444422222", "1122222"));
    }

    private static int theLongestSubSequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
