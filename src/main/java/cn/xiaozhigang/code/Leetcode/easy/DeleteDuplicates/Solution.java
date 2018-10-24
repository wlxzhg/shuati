package cn.xiaozhigang.code.Leetcode.easy.DeleteDuplicates;


import cn.xiaozhigang.code.Leetcode.util.ListNode;
import static cn.xiaozhigang.code.Leetcode.util.ListNode.*;

/**
 * 题目：删除排序链表中的重复元素
 *
 * */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        printListNode(so.deleteDuplicates(createListNode(new int[]{1,1,1,2,2,3,3})));
        printListNode(so.deleteDuplicates(createListNode(new int[]{1,1,1})));
        printListNode(so.deleteDuplicates(createListNode(new int[]{1})));
        printListNode(so.deleteDuplicates(createListNode(new int[]{1, 2, 3, 3, 4})));
        printListNode(so.deleteDuplicates(createListNode(new int[]{1, 2, 3, 4, 5})));

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;

        while (p != null && p.next != null) {
            if(p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }
}
