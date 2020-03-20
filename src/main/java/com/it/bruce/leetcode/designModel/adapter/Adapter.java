package com.it.bruce.leetcode.designModel.adapter;

public class Adapter extends OriginalStandard implements TargetStandard {
    @Override
    public void method2() {
        method1();
        System.out.println("start adapting method1");
        System.out.println("adapt finished,now this is method2");
    }
}
