package com.it.bruce.leetcode.eightQueen;

public class Main {
    private static int count = 0;    //记录成功的第几种可能
    private static int N = 8;    //几皇后

    public static void main(String[] args) {
        int[][] arr = new int[N][N];    //默认元素为0 1当皇后
        eightQueen(0, arr);    //打印八皇后所有可能的解 并且从第一行开始 0
    }

    //row [0,7]
    private static void eightQueen(int row, int[][] arr) {
        if (row == N) {    //row可以到达8 也就意味着前0~7行 每行都放有皇后
            count++;
            System.out.println("第" + count + "种：");
            for (int i = 0; i < arr.length; i++) {    //循环输出二维数组
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } else {    //如果没有完成八皇后 复制一个副本 对其副本进行改变
            //做一个数组备份
            int[][] newArr = new int[N][N];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    newArr[i][j] = arr[i][j];
                }
            }
            for (int col = 0; col < N; col++) {    //遍历 某行的每一列的元素
                if (noDangerous(row, col, newArr)) {    //判断这个位置是否可以放皇后 如果可以放
                    for (int c = 0; c < N; c++) {    //先清空这一行的元素（有可能以前这行有皇后 如果不清理则这行会有多个皇后）
                        newArr[row][c] = 0;
                    }
                    newArr[row][col] = 1;    //有皇后用1代表 没皇后用0代表
                    eightQueen(row + 1, newArr);//当前行找到皇后的位置后 在这个情况下 找下一行皇后放置的位置,这一个递归调用结束之后 在返回上一行 寻找其他的可能 在向重复上述的操作
                }
            }
        }
    }

    private static boolean noDangerous(int row, int col, int[][] newArr) {    //判断这个位置是否可以放皇后
        //正上
        for (int r = row - 1; r >= 0; r--) {
            if (newArr[r][col] == 1) {
                return false;
            }
        }
        //左上
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (newArr[r][c] == 1) {
                return false;
            }
        }
        //右上
        for (int r = row - 1, c = col + 1; r >= 0 && c < N; r--, c++) {
            if (newArr[r][c] == 1) {
                return false;
            }
        }
        return true;
    }
}
