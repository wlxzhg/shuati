package cn.xiaozhigang.code.Leetcode.nowcoder.PopulatingNextRightPointerInEachNodeII;

public class Solution {
    /**
     * 题目：给一颗二叉树的每个节点增加next指针。
     * 思路：一层层的遍历，且不用队列存储，因为遍历下一层时上一层已经有了next指针。
     *      关键是怎么找到下一层的第一个结点，目前的做法比较笨。
     * */
    public void connect2(TreeLinkNode root) {
        if(root == null)
            return;
        root.next = null;

        TreeLinkNode pHead = root,p;

        while(pHead != null) {
            p = pHead;
            pHead = null;
            while(p != null) {
                if(p.left != null) {
                    if(p.right != null)
                        p.left.next = p.right;
                    else
                        p.left.next = findNext(p.next);
                    if(pHead == null)
                        pHead = p.left;
                }


                if(p.right != null) {
                    p.right.next = findNext(p.next);
                    if(pHead == null)
                        pHead = p.right;
                }

                p = p.next;
            }
        }
    }


    private TreeLinkNode findNext(TreeLinkNode p) {
        while(p != null) {
            if(p.left != null) {
                p = p.left;
                break;
            }

            if(p.right != null) {
                p = p.right;
                break;
            }

            p = p.next;
        }

        return p;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        TreeLinkNode t7 = new TreeLinkNode(7);
        TreeLinkNode t8 = new TreeLinkNode(8);
        TreeLinkNode t9 = new TreeLinkNode(9);

        t1.left = t2;
        t1.right = t3;
        // t3.left = t6;
        t2.right = t5;
        t2.left = t4;
        t3.right = t7;
        t5.right = t8;

        t7.left = t9;

        so.connect2(t1);

        System.out.println(t1.next);
        System.out.println(t2.next.val);
        System.out.println(t3.next);
        System.out.println(t4.next.val);
        System.out.println(t5.next.val);

        System.out.println(t7.next);
        System.out.println(t8.next.val);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
