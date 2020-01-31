package com.it.bruce.leetcode._36.ValidSudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        char[][] arr = main.init();
        main.isValidSudoku(arr);

    }

    // 包含元素集合
    private Character[] demo = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};

    public boolean isValidSudoku(char[][] board) {
        if (checkHorizontal(board) && checkVertical(board) && checkGrid(board)) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }

    }

    /**
     * 初始化数组
     *
     * @return
     */
    private char[][] init() {
        char[][] arr = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

//        char[][] arr = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        return arr;
    }

    /**
     * 判断横向9个数字是否有重复
     *
     * @param arr
     * @return
     */
    private boolean checkHorizontal(char[][] arr) {
        List<Character> strings = Arrays.asList(demo);
        Set<Character> set = new HashSet<>();
        for (char[] a : arr) {
            set.clear();
            for (char aa : a) {
                if (aa == '.') {
                    continue;
                } else if (strings.contains(aa) && !set.contains(aa)) {
                    set.add(aa);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断竖向9个数字是否有重复
     *
     * @param arr
     * @return
     */
    private boolean checkVertical(char[][] arr) {
        char[][] tem = new char[9][9];
        // 将原9*9矩阵翻转
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tem[j][i] = arr[i][j];
            }
        }
        return checkHorizontal(tem);
    }

    /**
     * 判断3*3的9个数字是否有重复
     *
     * @param arr
     * @return
     */
    private boolean checkGrid(char[][] arr) {
        char[][] tem = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // [i / 3 * 3 + j / 3]:确认当前元素属于3*3矩阵中第几块
                // [j % 3 * 3 + i % 3]:确认当前元素在所属元素块中是第几个元素
                tem[i / 3 * 3 + j / 3][j % 3 * 3 + i % 3] = arr[i][j];
            }
        }
        return checkHorizontal(tem);
    }

}
