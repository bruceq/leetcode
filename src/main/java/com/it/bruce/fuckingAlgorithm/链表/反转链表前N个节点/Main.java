package com.it.bruce.fuckingAlgorithm.链表.反转链表前N个节点;

import com.it.bruce.fuckingAlgorithm.链表.ListNode;

public class Main {
    ListNode successor = null;

    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        main.reverseN(head, 3);
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
