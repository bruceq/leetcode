package com.it.bruce.leetcode.designModel.observe;

public class Main {
    public static void main(String[] args) {
        ObserverOperation observer = new ObserverOperation();
        observer.add(new Employee1());
        observer.add(new Employee2());
        observer.operation();
    }
}
