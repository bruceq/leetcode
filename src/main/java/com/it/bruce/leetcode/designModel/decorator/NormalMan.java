package com.it.bruce.leetcode.designModel.decorator;

public class NormalMan implements Man {
    private String name = null;

    public NormalMan(String name) {
        this.name = name;
    }

    @Override
    public void getManDesc() {
        System.out.print(name + ": ");
    }
}
