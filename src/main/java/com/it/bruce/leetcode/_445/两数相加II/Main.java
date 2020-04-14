package com.it.bruce.leetcode._445.两数相加II;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] s1 = {7, 2, 4, 3};
        ListNode listNode1 = null;
        for (int i = s1.length - 1; i >= 0; i--) {
            ListNode temNode = new ListNode(s1[i]);
            temNode.next = listNode1;
            listNode1 = temNode;
        }
        int[] s2 = {5, 6, 4};
        ListNode listNode2 = null;
        for (int i = s2.length - 1; i >= 0; i--) {
            ListNode temNode = new ListNode(s2[i]);
            temNode.next = listNode2;
            listNode2 = temNode;
        }
        Main main = new Main();
        ListNode listNode = main.addTwoNumbers(listNode1, listNode2);
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

}
