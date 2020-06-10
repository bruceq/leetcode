package com.it.bruce.leetcode.华为.模拟十;

import com.it.bruce.leetcode.华为.模拟一.Problem;

/**
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解，请返回“No solution”。
 * <p>
 * 如果方程有无限解，则返回“Infinite solutions”。
 * <p>
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 * <p>
 * 输入: "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 * <p>
 * 输入: "2x=x"
 * 输出: "x=0"
 * 示例 4:
 * <p>
 * 输入: "2x+3x-6x=x+2"
 * 输出: "x=-1"
 * 示例 5:
 * <p>
 * 输入: "x=x+2"
 * 输出: "No solution"
 */
public class Problem3 {
    public static void main(String[] args) {
        Problem3 main = new Problem3();
        System.out.println(main.solveEquation("2=-x"));
    }

    public String solveEquation(String equation) {
        String[] partition = equation.split("=");
        Integer leftX = 0;
        Integer leftNum = 0;
        Integer rightX = 0;
        Integer rightNum = 0;

        if (partition[0].startsWith("-")) {
            partition[0] = "0" + partition[0];
        }
        String[] leftPlusPart = partition[0].split("\\+");
        for (String plus : leftPlusPart) {
            String[] minusPart = plus.split("-");
            if (minusPart.length > 1) {
                for (int i = 0; i < minusPart.length; i++) {
                    if (i == 0) {
                        if (minusPart[i].equals("x")) {
                            leftX += 1;
                        } else if (minusPart[i].contains("x")) {
                            leftX += Integer.parseInt(minusPart[i].substring(0, minusPart[i].indexOf("x")));
                        } else {
                            leftNum += Integer.parseInt(minusPart[i]);
                        }
                    } else {
                        if (minusPart[i].equals("x")) {
                            leftX -= 1;
                        } else if (minusPart[i].contains("x")) {
                            leftX -= Integer.parseInt(minusPart[i].substring(0, minusPart[i].indexOf("x")));
                        } else {
                            leftNum -= Integer.parseInt(minusPart[i]);
                        }
                    }
                }
            } else {
                if (plus.equals("x")) {
                    leftX += 1;
                } else if (plus.contains("x")) {
                    leftX += Integer.parseInt(plus.substring(0, plus.indexOf("x")));
                } else {
                    leftNum += Integer.parseInt(plus);
                }
            }
        }

        if (partition[1].startsWith("-")) {
            partition[1] = "0" + partition[1];
        }
        String[] rightPlusPart = partition[1].split("\\+");
        for (String plus : rightPlusPart) {
            String[] minusPart = plus.split("-");
            if (minusPart.length > 1) {
                for (int i = 0; i < minusPart.length; i++) {
                    if (i == 0) {
                        if (minusPart[i].equals("x")) {
                            rightX += 1;
                        } else if (minusPart[i].contains("x")) {
                            rightX += Integer.parseInt(minusPart[i].substring(0, minusPart[i].indexOf("x")));
                        } else {
                            rightNum += Integer.parseInt(minusPart[i]);
                        }
                    } else {
                        if (minusPart[i].equals("x")) {
                            rightX -= 1;
                        } else if (minusPart[i].contains("x")) {
                            rightX -= Integer.parseInt(minusPart[i].substring(0, minusPart[i].indexOf("x")));
                        } else {
                            rightNum -= Integer.parseInt(minusPart[i]);
                        }
                    }
                }
            } else {
                if (plus.equals("x")) {
                    rightX += 1;
                } else if (plus.contains("x")) {
                    rightX += Integer.parseInt(plus.substring(0, plus.indexOf("x")));
                } else {
                    rightNum += Integer.parseInt(plus);
                }
            }
        }

        int x = leftX - rightX;
        int num = rightNum - leftNum;
        if (x == 0 && num == 0) {
            return "Infinite solutions";
        } else if (x == 0) {
            return "No solution";
        } else {
            return "x=" + num / x;
        }
    }

}
