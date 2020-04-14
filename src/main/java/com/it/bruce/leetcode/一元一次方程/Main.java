package com.it.bruce.leetcode.一元一次方程;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.solve("-3x-5=3x-1"));
    }

    public double solve(String s) {
        String[] strs = s.split("=");
        if (!strs[0].startsWith("-")) {
            strs[0] = "+" + strs[0];
        }
        if (!strs[1].startsWith("-")) {
            strs[1] = "+" + strs[1];
        }
        strs[0] += "+";
        strs[1] += "+";
        String sign = "+";
        int num = 0;
        int cha = 0;
        String tem = "";
        for (String ss : strs[0].split("")) {
            if (ss.matches("-") | ss.matches("\\+")) {
                if (!tem.isEmpty()) {
                    if (hasChar(tem)) {
                        if (sign.equals("-")) {
                            if (tem.length() == 1) {
                                cha = cha - 1;
                            } else {
                                String substring = tem.substring(0, tem.length() - 1);
                                cha = cha - Integer.parseInt(substring);
                            }
                        } else {
                            if (tem.length() == 1) {
                                cha = cha + 1;
                            } else {
                                String substring = tem.substring(0, tem.length() - 1);
                                cha = cha + Integer.parseInt(substring);
                            }
                        }
                    } else {
                        if (sign.equals("-")) {
                            num = num - Integer.parseInt(tem);
                        } else {
                            num = num + Integer.parseInt(tem);
                        }
                    }
                }
                tem = "";
                sign = ss;
            } else {
                tem += ss;
            }
        }
        for (String ss : strs[1].split("")) {
            if (ss.matches("-") | ss.matches("\\+")) {
                if (!tem.isEmpty()) {
                    if (hasChar(tem)) {
                        if (sign.equals("-")) {
                            if (tem.length() == 1) {
                                cha = cha + 1;
                            } else {
                                String substring = tem.substring(0, tem.length() - 1);
                                cha = cha + Integer.parseInt(substring);
                            }
                        } else {
                            if (tem.length() == 1) {
                                cha = cha - 1;
                            } else {
                                String substring = tem.substring(0, tem.length() - 1);
                                cha = cha - Integer.parseInt(substring);
                            }
                        }
                    } else {
                        if (sign.equals("-")) {
                            num = num + Integer.parseInt(tem);
                        } else {
                            num = num - Integer.parseInt(tem);
                        }
                    }
                }
                tem = "";
                sign = ss;
            } else {
                tem += ss;
            }
        }
        return Double.valueOf(num) / Double.valueOf(cha);
    }

    private boolean hasChar(String str) {
        for (String s : str.split("")) {
            if (s.matches("[a-z]")) {
                return true;
            }
        }
        return false;
    }
}
