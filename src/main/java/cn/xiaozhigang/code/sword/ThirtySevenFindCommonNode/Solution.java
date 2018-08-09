package cn.xiaozhigang.code.sword.ThirtySevenFindCommonNode;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        n5.next = n6;

        ListNode result = so.FindFirstCommonNode(n1,n5);
        System.out.println(result.val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;

        ListNode p = pHead1;
        int count1 = 0;
        while (p != null) {
            count1++;
            p = p.next;
        }

        int count2 = 0;
        p = pHead2;
        while (p != null) {
            count2++;
            p = p.next;
        }

        ListNode pLong = (count1 >= count2)?pHead1:pHead2;
        ListNode pShort = (count1 < count2)?pHead1:pHead2;

        int count = Math.abs(count1 - count2);
        for(int i = 0; i < count; i++) {
            pLong = pLong.next;
        }

        while (pLong != pShort) {
            pLong = pLong.next;
            pShort = pShort.next;
        }

        return pLong;
    }
}
