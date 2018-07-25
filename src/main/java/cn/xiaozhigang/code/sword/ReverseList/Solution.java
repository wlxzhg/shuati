package cn.xiaozhigang.code.sword.ReverseList;

public class Solution {
    /**
     * 反转链表思路：
     * 将链表看作两部分，一部分是新的反转后的，一部分待反转的
     * 1.p1指向反转后链表的头部，p2指向待反转部分的下一个节点
     * 2.将p2的下一个指向p1，并正确更新p1,p2即可
     * */
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;

        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;

        while (p2 != null) {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return p1;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode newHead = so.ReverseList(l2);
        for(ListNode p = newHead;p != null;p=p.next) {
            System.out.println(p.val);
        }
    }
}