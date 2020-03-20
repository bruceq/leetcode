package com.it.bruce.leetcode.designModel.builder;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Builder()
                .cpu("cpu")
                .screen("screen")
                .memory("memory")
                .mainboard("mainboard")
                .build();
    }
}
