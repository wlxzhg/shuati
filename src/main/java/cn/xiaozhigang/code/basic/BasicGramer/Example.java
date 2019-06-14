package cn.xiaozhigang.code.basic.BasicGramer;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Example {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l3;
        l2.next = l4;

        ListNode res = mergeList(l2,l3);
        for(ListNode p = res; p != null; p = p.next)
            System.out.println(p.val);
    }

    private static ListNode mergeList(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(l1 != null && l2 !=  null) {
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
        else
            p.next = l2;

        return dummy.next;
    }
}
