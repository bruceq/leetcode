package com.it.bruce.leetcode._面试题交换数字;

public class Main {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }
}
