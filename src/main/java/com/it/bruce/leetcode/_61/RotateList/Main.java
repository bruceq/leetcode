package com.it.bruce.leetcode._61.RotateList;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Main main = new Main();
        main.rotateRight(head, 2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        p.next = head;
        k %= len;
        for (int i = 0; i < len - k; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
