package com.it.bruce.leetcode._79.单词搜索;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(main.exist(board, "ABCCED"));
    }


    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res = res || dfs(board, word, 0, i, j, visited);
                }
                if (res) {
                    return res;
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, String word, int wordIndex, int row, int col, boolean[][] visited) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(wordIndex)) {
            return false;
        }
        visited[row][col] = true;
        if (dfs(board, word, wordIndex + 1, row + 1, col, visited) ||
                dfs(board, word, wordIndex + 1, row, col + 1, visited) ||
                dfs(board, word, wordIndex + 1, row - 1, col, visited) ||
                dfs(board, word, wordIndex + 1, row, col - 1, visited)) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }

}
