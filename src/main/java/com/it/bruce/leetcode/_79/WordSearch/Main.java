package com.it.bruce.leetcode._79.WordSearch;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        char[][] board = {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(main.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0
                || board.length * board[0].length < word.length())
            return false;
        boolean[][] mark = new boolean[board.length][board[0].length];
        boolean res = false;
        // iterate board, find the match starting character to pass to findWord function
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    res = res || findWord(board, word, 0, i, j, mark);
                if (res)
                    return res;
            }
        }
        return res;
    }

    public boolean findWord(char[][] board, String word, int wordIndex,
                            int row, int col, boolean[][] markBoard) {
        // base case 1: if exceed word's length, meaning it is done and found the word
        if (wordIndex == word.length())
            return true;
        /* base case 2: if this character is out of bound or
         * this character is not match to word's character or
         * hits character has been already visited
         */
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0
                || word.charAt(wordIndex) != board[row][col] || markBoard[row][col])
            return false;
        // mark this char as visited
        markBoard[row][col] = true;
        // follow top, right, bottom, left order to check character
        // if any direction future path return true, meaning no need to continue other directions
        if (findWord(board, word, wordIndex + 1, row - 1, col, markBoard) || // go top
                findWord(board, word, wordIndex + 1, row, col + 1, markBoard) || // go right
                findWord(board, word, wordIndex + 1, row + 1, col, markBoard) || // go bottom:
                findWord(board, word, wordIndex + 1, row, col - 1, markBoard))   // go left:
        {
            return true;
        }
        markBoard[row][col] = false; // clear the mark of this character
        // if this this character's all four directions path has failed, return false to last level
        return false;
    }
}
