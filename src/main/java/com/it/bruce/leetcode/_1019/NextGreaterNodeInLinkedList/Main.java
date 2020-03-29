package com.it.bruce.leetcode._1019.NextGreaterNodeInLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(1);
        ListNode fisrt = new ListNode(7);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(1);
        ListNode forth = new ListNode(9);
        ListNode fifth = new ListNode(2);
        ListNode sixth = new ListNode(5);
        ListNode seventh = new ListNode(1);
        head.next = fisrt;
        fisrt.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        main.nextLargerNodes(head);

    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while (head != null) {
            list.add(head.val);
            head = head.next;
            index++;
        }
        int[] res = new int[index];
        Stack<Integer> stack = new Stack<>();
        // 遍历每个元素位置，判断栈是否为空
        for (int i = 0; i < list.size(); i++) {
            while (!stack.empty() && list.get(i) > list.get(stack.peek())) {
                int top = stack.pop();
                res[top] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
