package com.it.bruce.leetcode.designModel.factory;

public class ShoesFactory implements Factory {
    @Override
    public Producer produce() {
        return new ShoesProducer();
    }
}
