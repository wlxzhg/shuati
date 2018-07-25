package cn.xiaozhigang.code.sword.FindKthToTail;

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0) return null;
        ListNode p1 = head,p2 = head;
        int kth = k;
        while(kth > 1 && p1 != null) {
            kth--;
            p1 = p1.next;
        }
        if(p1 == null) return null;

        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        Solution so = new Solution();

        for(int i = 0 ; i <= 3; i++) {
            ListNode p = so.FindKthToTail(l1, i);
            if(p != null)
                System.out.println(p.val);
            else
                System.out.println("is null");
        }
    }
}
