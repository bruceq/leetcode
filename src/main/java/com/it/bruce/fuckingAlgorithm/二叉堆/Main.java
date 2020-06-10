package com.it.bruce.fuckingAlgorithm.二叉堆;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // 大顶堆
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>(Collections.reverseOrder());
        bigQueue.offer(2);
        bigQueue.offer(6);
        bigQueue.offer(1);
        bigQueue.offer(5);
        bigQueue.offer(3);
        bigQueue.offer(4);
        // 小顶堆
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
        smallQueue.offer(2);
        smallQueue.offer(1);
        smallQueue.offer(6);
        smallQueue.offer(3);
        smallQueue.offer(5);
        smallQueue.offer(4);
        System.out.println(bigQueue);
        System.out.println(smallQueue);
        System.out.println(bigQueue.peek());
        System.out.println(smallQueue.peek());
    }
}
