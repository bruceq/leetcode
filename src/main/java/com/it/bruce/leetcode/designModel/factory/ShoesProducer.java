package com.it.bruce.leetcode.designModel.factory;

public class ShoesProducer implements Producer {
    @Override
    public void produce() {
        System.out.println("produce shoes");
    }
}
