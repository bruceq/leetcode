package com.it.bruce.leetcode._38.CountandSay;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.countAndSay(30));
    }

    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * <p>
     * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
     * <p>
     * Note: Each term of the sequence of integers will be represented as a string.
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        // 题目要求1<=n<=30，则初始化数组大小为31
        String[] strs = new String[31];
        // 给出基础的值
        strs[0] = "1";
        // 从第二个数组开始，对strs进行计算赋值
        for (int i = 1; i < n; i++) {
            String[] ss = strs[i - 1].split("");
            int count = 1;
            StringBuilder sb = new StringBuilder();
            // 如果只有1个数字，则strs[i]一定为"1n"
            if (ss.length == 1) {
                strs[i] = sb.append(count).append(ss[0]).toString();
            }
            // 对前一个值按照题目规则进行解析
            for (int j = 0; j < ss.length - 1; j++) {
                // 如果当前数字是strs[i-1]的倒数第二个数字，按条件输出结果
                if (j == ss.length - 2) {
                    if (ss[j].equals(ss[j + 1])) {
                        count++;
                        strs[i] = sb.append(count).append(ss[j]).toString();
                        break;
                    } else {
                        strs[i] = sb.append(count).append(ss[j]).append(1).append(ss[j + 1]).toString();
                        break;
                    }
                } else {
                    // 如果当前数字不是strs[i-1]的倒数第二个数字，则按条件进行过程逻辑处理
                    if (ss[j].equals(ss[j + 1])) {
                        count++;
                    } else {
                        sb.append(count);
                        sb.append(ss[j]);
                        count = 1;
                    }
                }
            }
        }
        return strs[n - 1];
    }
}
