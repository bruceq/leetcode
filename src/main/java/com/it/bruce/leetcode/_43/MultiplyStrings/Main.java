package com.it.bruce.leetcode._43.MultiplyStrings;

import java.math.BigDecimal;

public class Main {

    public String multiply(String num1, String num2) {
        BigDecimal n1 = new BigDecimal(num1);
        BigDecimal n2 = new BigDecimal(num2);
        return n1.multiply(n2).toPlainString();
    }
}
