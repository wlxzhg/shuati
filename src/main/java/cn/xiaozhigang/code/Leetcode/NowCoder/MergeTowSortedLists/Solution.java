package cn.xiaozhigang.code.Leetcode.NowCoder.MergeTowSortedLists;

public class Solution {

    /**
     * 题目：合并两个有序链表为新的有序链表。
     * 思路：1.使用合并排序的方法
     *       2.头结点的问题，这里巧妙地是使用了一个虚节点，作为开始结点，最后返回该结点的下一个
     *          巧妙地避开了l1,l2为空的判断，和初始化头结点的过程。
     * */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(0);
        ListNode p = pHead;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1 != null)
            p.next = l1;
        else if(l2 != null)
            p.next = l2;

        return pHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1,p2 = l2,pNew = null,pHead = null;

        if(p1 == null) return p2;
        if(p2 == null) return p1;

        if(p1.val < p2.val) {
            pNew = p1;
            p1 = p1.next;
        } else {
            pNew = p2;
            p2 = p2.next;
        }
        pHead = pNew;

        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                pNew.next = p1;
                p1 = p1.next;
                pNew = pNew.next;
            } else {
                pNew.next = p2;
                p2 = p2.next;
                pNew = pNew.next;
            }
        }

        if(p1 != null)
            pNew.next = p1;
        if(p2 != null)
            pNew.next = p2;

        return pHead;
    }


    public static void main(String[] args) {
        Solution so = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l3;
        l3.next = l5;
        l5.next = null;

        l2.next = l4;
        l4.next = l6;
        l6.next = null;

        ListNode p =so.mergeTwoLists(l5,null);

        while(p != null) {
            System.out.print(p.val);
            if(p.next != null)
                System.out.print(" ");
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
