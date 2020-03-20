package com.it.bruce.leetcode.designModel.decorator;

public abstract class AttachedPropertiesDecorator implements Man {
    private Man man;

    public AttachedPropertiesDecorator(Man man) {
        this.man = man;
    }

    public void getManDesc() {
        man.getManDesc();
    }
}
