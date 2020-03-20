package com.it.bruce.leetcode.designModel.singleton;

public class SingletonHunger {
    private static volatile SingletonHunger single = new SingletonHunger();

    public SingletonHunger() {
    }

    public SingletonHunger getInstance() {
        return single;
    }
}
