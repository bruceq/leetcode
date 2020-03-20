package com.it.bruce.leetcode.designModel.factory;

public class ShirtFactory implements Factory {
    @Override
    public Producer produce() {
        return new ShirtProducer();
    }
}
