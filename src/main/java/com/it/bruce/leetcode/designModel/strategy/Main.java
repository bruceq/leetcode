package com.it.bruce.leetcode.designModel.strategy;

public class Main {
    public static void main(String[] args) {
        Sale halfSale = new HalfSale();
        double price = halfSale.calculate(10);
    }
}
