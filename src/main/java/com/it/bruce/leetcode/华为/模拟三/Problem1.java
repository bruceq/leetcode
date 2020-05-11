package com.it.bruce.leetcode.华为.模拟三;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 main = new Problem1();
        System.out.println(main.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int index = 0;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (index < a.length() || index < b.length()) {
            int i1 = 0;
            int i2 = 0;
            if (index < a.length()) {
                i1 = a.toCharArray()[a.length() - 1 - index] - '0';
            }
            if (index < b.length()) {
                i2 = b.toCharArray()[b.length() - 1 - index] - '0';
            }
            int i = i1 + i2;
            if (i + add == 3) {
                sb.append(1);
                add = 1;
            } else if (i + add == 2) {
                sb.append(0);
                add = 1;
            } else if (i + add == 1) {
                sb.append(1);
                add = 0;
            } else if (i + add == 0) {
                sb.append(0);
                add = 0;
            }
            index++;
        }
        if (add == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
