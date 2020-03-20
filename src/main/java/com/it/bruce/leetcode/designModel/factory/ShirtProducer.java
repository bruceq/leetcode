package com.it.bruce.leetcode.designModel.factory;

public class ShirtProducer implements Producer {
    @Override
    public void produce() {
        System.out.println("produce Shirt");
    }
}
