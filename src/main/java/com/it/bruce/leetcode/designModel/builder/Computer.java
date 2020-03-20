package com.it.bruce.leetcode.designModel.builder;

public class Computer {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    public Computer(Builder builder) {
        cpu = builder.getCpu();
        screen = builder.getScreen();
        memory = builder.getMemory();
        mainboard = builder.getMainboard();
    }
}
