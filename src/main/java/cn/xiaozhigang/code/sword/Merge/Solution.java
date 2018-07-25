package cn.xiaozhigang.code.sword.Merge;

import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(5);
        p1.next = p2; p2.next = p3; p3.next = null;

        ListNode p4 = new ListNode(2);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(6);
        p4.next = p5; p5.next = p6; p6.next = null;

        ListNode p = so.Merge(p1, p4);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode p1 = list1,p2 = list2,newHead = null;
        if(p1.val <= p2.val) {
            newHead = p1;
            p1 = p1.next;
        } else {
            newHead = p2;
            p2 = p2.next;
        }
        ListNode p3 = newHead;
        while (p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        while (p1 != null) {
            p3.next = p1;
            p3 = p3.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            p3.next = p2;
            p3 = p3.next;
            p2 = p2.next;
        }
        p3.next = null;

        return newHead;
    }
}
