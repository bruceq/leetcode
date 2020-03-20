package com.it.bruce.leetcode.designModel.singleton;

public class SingletonLazy {
    private static volatile SingletonLazy single = null;

    public SingletonLazy() {
    }

    public SingletonLazy getInstance() {
        if (single == null) {
            synchronized (this) {
                if (single == null) {
                    single = new SingletonLazy();
                }
            }
        }
        return single;
    }
}
