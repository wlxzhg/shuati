package cn.xiaozhigang.code.sword.CloneRandomList;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode tmp = new RandomListNode(p.label);
            tmp.next = p.next;
            p.next = tmp;
            p = tmp.next;
        }
        p = pHead;
        RandomListNode result = pHead.next;

        while (p != null && p.next != null) {
            if(p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }
        p = pHead;
        while (p != null && p.next != null) {
            RandomListNode tmp = p.next;
            p.next = p.next.next;
            p = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.random = c;
        b.random = e;
        c.random = null;
        d.random = b;
        e.random = null;
        RandomListNode result = so.Clone(a);
        RandomListNode p = result;
        while (p != null) {
            System.out.println(p.label + "\t" + ((p.next != null)?p.next.label:"") + "\t" +((p.random != null)?p.random.label:""));
            p = p.next;
        }
        System.out.println("");
        p = a;
        System.out.println("a == nul");
        while (p != null) {
            System.out.println(p.label + "\t" + ((p.next != null)?p.next.label:"") + "\t" + ((p.random != null)?p.random.label:""));
            p = p.next;
        }
    }
}
