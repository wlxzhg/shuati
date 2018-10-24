package cn.xiaozhigang.code.Leetcode.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {val = x;}

    public static void printListNode(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            if(p.next != null)
                System.out.print(" ");
            else
                System.out.println();
            p = p.next;
        }
    }

    public static ListNode createListNode(int[] arr) {
        if(arr == null) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for(int i = 1; i < arr.length; i++) {
            ListNode index = new ListNode(arr[i]);
            p.next = index;
            p = index;
        }

        return head;
    }
}
