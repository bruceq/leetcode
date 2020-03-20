package com.it.bruce.leetcode.designModel.decorator;

public class HouseDecoratorImpl extends AttachedPropertiesDecorator {
    private String house = "有房";

    public HouseDecoratorImpl(Man man) {
        super(man);
    }

    public void addHouse() {
        System.out.print(house + " ");
    }

    @Override
    public void getManDesc() {
        super.getManDesc();
        addHouse();
    }
}
