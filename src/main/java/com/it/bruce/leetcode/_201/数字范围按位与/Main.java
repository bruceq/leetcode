package com.it.bruce.leetcode._201.数字范围按位与;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.decimal2Binary(51));
        System.out.println(main.binary2Decimal("110011"));
        System.out.println(main.rangeBitwiseAnd(5, 7));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int diffBits = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            diffBits++;
        }
        return n << diffBits;
    }
//    public int rangeBitwiseAnd(int m, int n) {
//        if (m == n) {
//            return m;
//        }
//        int res = m;
//        for (int i = m + 1; i <= n; i++) {
//            String binaryM = decimal2Binary(res);
//            String binaryN = decimal2Binary(i);
//            int lenM = binaryM.length() - 1;
//            int lenN = binaryN.length() - 1;
//            res = getTwoNumsAndOperation(binaryM, binaryN, lenM, lenN);
//        }
//        return res;
//    }

    private int getTwoNumsAndOperation(String binaryM, String binaryN, int lenM, int lenN) {
        int res = 0;
        int ratio = 1;
        while (lenM >= 0 || lenN >= 0) {
            int tempM = 0;
            int tempN = 0;
            if (lenM >= 0) {
                tempM = Integer.parseInt(String.valueOf(binaryM.charAt(lenM)));
                lenM--;

            }
            if (lenN >= 0) {
                tempN = Integer.parseInt(String.valueOf(binaryN.charAt(lenN)));
                lenN--;
            }
            res += (tempM & tempN) * ratio;
            ratio *= 2;
        }
        return res;
    }


    private String decimal2Binary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num / 2 > 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        sb.append(num);
        return sb.reverse().toString();
    }

    private int binary2Decimal(String num) {
        char[] chars = num.toCharArray();
        int ratio = 1;
        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += Integer.parseInt(String.valueOf(chars[i])) * ratio;
            ratio *= 2;
        }
        return res;
    }
}
