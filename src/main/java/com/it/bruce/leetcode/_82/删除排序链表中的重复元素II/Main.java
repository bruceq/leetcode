package com.it.bruce.leetcode._82.删除排序链表中的重复元素II;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        Main main = new Main();
        main.deleteDuplicates(head);

    }

    private int repeatNum = Integer.MAX_VALUE;

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        // 1. 递归中获取正确的 next
        head.next = deleteDuplicates(head.next);

        // 2. head 值等于 next ， 标记 repeatNum
        if(head != null && head.next != null && head.val == head.next.val){
            repeatNum = head.val;
        }

        // 3. head 值为 repeatNum 一律跳过
        while(repeatNum != Integer.MAX_VALUE && head != null && head.val == repeatNum){
            head = head.next;
        }

        return head;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
