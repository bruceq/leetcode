package com.it.bruce.leetcode.designModel.strategy;

public class HalfSale extends Sale {
    @Override
    public double calculate(double price) {
        return price * 0.5;
    }
}
