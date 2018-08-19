package cn.xiaozhigang.code.sword.TwentyThreeEntryNodeOfLoop;

/**
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 链表环的入口
 * */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l2;
//        l4.next = l5;
//        l5.next = l4;

        System.out.println(so.EntryNodeOfLoop(l4).val);
    }


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead,fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null || fast.next == null) return null;

        int loopCount = 1;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            loopCount++;
        }
        slow = fast = pHead;
        while (loopCount > 0) {
            fast = fast.next;
            loopCount--;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
