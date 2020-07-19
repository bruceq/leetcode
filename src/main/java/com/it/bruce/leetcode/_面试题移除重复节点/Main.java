package com.it.bruce.leetcode._面试题移除重复节点;

import com.it.bruce.fuckingAlgorithm.链表.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        main.removeDuplicateNodes(head);
    }


    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            set.add(cur.val);
            if (set.contains(cur.next.val))
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }
}
