package com.it.bruce.leetcode.designModel.builder;

public class Builder {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    public String getCpu() {
        return cpu;
    }

    public String getScreen() {
        return screen;
    }

    public String getMemory() {
        return memory;
    }

    public String getMainboard() {
        return mainboard;
    }

    public Builder cpu(String val) {
        cpu = val;
        return this;
    }

    public Builder screen(String val) {
        screen = val;
        return this;
    }

    public Builder memory(String val) {
        memory = val;
        return this;
    }

    public Builder mainboard(String val) {
        mainboard = val;
        return this;
    }

    public Computer build() {
        return new Computer(this);
    }
}
