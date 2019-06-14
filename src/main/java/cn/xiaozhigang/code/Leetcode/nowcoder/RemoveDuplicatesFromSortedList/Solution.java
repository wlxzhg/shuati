package cn.xiaozhigang.code.Leetcode.nowcoder.RemoveDuplicatesFromSortedList;

public class Solution {
    /**
     * 题目：删除链表中的重复结点
     * 思路：两个指针。p1指向已经没有重复元素的链表的结尾。
     *      p2对原链表进行遍历。
     *      特别注意：更新p1时，p1要和原链表断开，即保持p1.next=null.
     *      否则对于1.2.2.4.4的情况会返回1,2,4,4
     * */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode p1 = head,p2 = head.next;

        while(p2 != null) {
            if(p2.val != p1.val) {
                p1.next = p2;
                p1 = p2;
            }
            p2 = p2.next;
            p1.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        // l3.next = l4;
        // l4.next = l5;

        ListNode p = so.deleteDuplicates(l1);

        while(p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
