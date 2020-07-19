package com.it.bruce.leetcode.华为.模拟十三;

import com.it.bruce.fuckingAlgorithm.链表.ListNode;
import com.it.bruce.leetcode.华为.模拟一.Problem;

public class Problem1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        Problem1 main = new Problem1();
        main.rotateRight(head, 2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        while (cur.next != null) {
            cur.next = cur;
        }
        return head;
    }

    private ListNode moveOneStep(ListNode head) {
        ListNode cur = head;
        int tem = 0;
        while (cur.next != null) {
            tem = cur.val;
            cur.next.val = tem;
            cur = cur.next;
        }
        return head;
    }
}
