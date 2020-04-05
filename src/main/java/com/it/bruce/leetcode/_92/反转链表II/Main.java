package com.it.bruce.leetcode._92.反转链表II;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        Main main = new Main();
        main.reverseBetween(head, 2, 4);

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode first = null;
        ListNode last = null;
        ListNode con = null;
        int index = 1;
        while (head != null) {
            if (index < m) {
                if (index == 1) {
                    first = head;
                }
            } else if (index < n) {
                if (index == m) {
                    first.next = null;
                    con = head;
                }
            } else {
                if (index == n) {
                    con.next = null;
                }
                last = head;
            }
            head = head.next;
            index++;
        }
        return con;
    }
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        // Empty list
//        if (head == null) {
//            return null;
//        }
//        // Move the two pointers until they reach the proper starting point
//        // in the list.
//        ListNode cur = head, prev = null;
//        while (m > 1) {
//            prev = cur;
//            cur = cur.next;
//            m--;
//            n--;
//        }
//        // The two pointers that will fix the final connections.
//        ListNode con = prev, tail = cur;
//        // Iteratively reverse the nodes until n becomes 0.
//        ListNode third = null;
//        while (n > 0) {
//            third = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = third;
//            n--;
//        }
//        // Adjust the final connections as explained in the algorithm
//        if (con != null) {
//            con.next = prev;
//        } else {
//            head = prev;
//        }
//        tail.next = cur;
//        return head;
//    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
