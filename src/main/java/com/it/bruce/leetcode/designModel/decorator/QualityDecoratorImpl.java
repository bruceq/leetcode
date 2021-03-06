package com.it.bruce.leetcode.designModel.decorator;

public class QualityDecoratorImpl extends AttachedPropertiesDecorator {
    private String quality = "有好品质";

    public QualityDecoratorImpl(Man man) {
        super(man);
    }

    public void addQuality() {
        System.out.print(quality + " ");
    }

    @Override
    public void getManDesc() {
        super.getManDesc();
    }
}
