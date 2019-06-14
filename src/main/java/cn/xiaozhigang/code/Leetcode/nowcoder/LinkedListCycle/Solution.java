package cn.xiaozhigang.code.Leetcode.nowcoder.LinkedListCycle;

public class Solution {
    /**
     * 题目：判断链表是否有环
     * 思路：使用快慢指针，快指针每次走两步，慢指针每次走一步。
     *       若两个指针相遇了说明有环，若快指针走到了末尾说明没环。
     * 说明：若有环快慢指针一定相遇吗？
     *      一定相遇。快指针和慢指针先后进入环中，假设快指针前边n步是
     *      慢指针。每次走动，两者距离都会减一，所以最终会相遇。
     * */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = null;
        l3.next = l4;
        l4.next = l5;
        l5.next = l4;

        System.out.println(so.hasCycle(l1));

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
