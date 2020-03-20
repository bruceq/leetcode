package com.it.bruce.leetcode.designModel.decorator;

public class CarDecoratorImpl extends AttachedPropertiesDecorator{
    private String car = "有车";

    public CarDecoratorImpl(Man man) {
        super(man);
    }

    public void addCar() {
        System.out.print(car + " ");
    }

    @Override
    public void getManDesc() {
        super.getManDesc();
        addCar();
    }
}
