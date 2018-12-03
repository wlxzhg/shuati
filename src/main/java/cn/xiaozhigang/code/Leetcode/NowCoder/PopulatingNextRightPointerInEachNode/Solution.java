package cn.xiaozhigang.code.Leetcode.NowCoder.PopulatingNextRightPointerInEachNode;

import java.util.LinkedList;


public class Solution {
    /**
     * 题目：求出二叉树中每个结点的'next'结点，next是指在同一层中右边相邻的结点。
     *       显然一层中最后一个结点的next结点为null。
     * 思路：按层次遍历，遍历同时保存上一个遍历的结点，将上一个结点的next赋值为
     *       当前遍历结点。最后一个结点的next赋值为null。
     * 思路2：递归方式。由于是完全二叉树，每个节点必有左右孩子。那么左孩子的next
     *        便是其右孩子。右孩子的next是父节点的next的右孩子
     * */
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;

        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        root.next = null;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeLinkNode last = null;
            for(int i = 0; i < levelSize; i++) {
                TreeLinkNode index = queue.remove();
                if(index.left != null)
                    queue.add(index.left);

                if(index.right != null)
                    queue.add(index.right);

                if(last != null)
                    last.next = index;

                last = index;
            }
            last.next = null;
        }
    }

    public void connect2(TreeLinkNode root) {
        if(root == null)
            return;

        if(root.left != null) {
            root.left.next = root.right;
        }

        if(root.right != null)
            if(root.next != null)
                root.right.next = root.next.left;
            else
                root.right.next = null;

        connect2(root.left);
        connect2(root.right);
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

        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;

        so.connect(t1);

        System.out.println(t1.next);
        System.out.println(t2.next.val);
        System.out.println(t3.next);
        System.out.println(t4.next.val);
        System.out.println(t5.next.val);
        System.out.println(t6.next.val);
        System.out.println(t7.next);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
