package com.it.bruce.leetcode._8.字符串转换整数;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.myAtoi("2147483648"));
    }

    /**
     * trim去前后空格
     * 判断第一位是否是"-"、"+"
     * 判断第一位是否是数字，是的话截取到第一位非数字内容
     * 如果第一位不是数字，就返回0
     * 如果返回的数字超出整形范围的最大最小值，则返回最大最小值
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        String res = "";
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.length() == 1) {
                return 0;
            }
            res += String.valueOf(str.charAt(0));
            for (int i = 1; i < str.length(); i++) {
                if (!String.valueOf(str.charAt(1)).matches("[0-9]")) {
                    return 0;
                }
                if (String.valueOf(str.charAt(i)).matches("[0-9]")) {
                    res += String.valueOf(str.charAt(i));
                } else {
                    break;
                }
            }
            try {
                return Integer.parseInt(res);
            } catch (NumberFormatException e) {
                if (str.charAt(0) == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } else if (String.valueOf(str.charAt(0)).matches("[0-9]")) {
            for (int i = 0; i < str.length(); i++) {
                if (String.valueOf(str.charAt(i)).matches("[0-9]")) {
                    res += String.valueOf(str.charAt(i));
                } else {
                    break;
                }
            }
            try {
                return Integer.parseInt(res);
            } catch (NumberFormatException e) {
                    return Integer.MAX_VALUE;
            }
        } else {
            return 0;
        }
    }

}
