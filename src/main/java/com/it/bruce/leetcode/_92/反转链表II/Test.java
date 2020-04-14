package com.it.bruce.leetcode._92.反转链表II;

public class Test {

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        ListNode1 head1 = new ListNode1(2);
        ListNode1 head2 = new ListNode1(3);
        ListNode1 head3 = new ListNode1(4);
        ListNode1 head4 = new ListNode1(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        Test main = new Test();
        main.reverseBetween(head);

    }

    ListNode1 newHead = null;
    ListNode1 node;

    public ListNode1 reverseBetween(ListNode1 head) {
        while (head != null) {
            node = head;
            head = head.next;
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
    }
}
