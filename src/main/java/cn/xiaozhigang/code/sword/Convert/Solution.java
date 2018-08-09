package cn.xiaozhigang.code.sword.Convert;

import cn.xiaozhigang.code.question.CME.Test;

public class Solution {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        TreeNode head = (new Solution()).Convert(t1);
//        System.out.println(head.val);
//        System.out.println(head.right.val);
//        System.out.println(head.right.right.val);
//        System.out.println(head.right.right.right.val);
//        System.out.println(head.right.right.right.right.val);
//        System.out.println(head.right.right.right.right.right.val);
//        System.out.println(head.right.right.right.right.right.right.val);
        TreeNode p = head;
        while (p != null && p.right != null) {
            System.out.print(p.val + "\t");
            p = p.right;
        }
        System.out.println(p.val);
        System.out.println();


        while (p != null && p.left != null) {
            System.out.println(p.val + "\t");
            p = p.left;
        }
        System.out.println(p.val);
    }

    /**
     * 递归
     * 方法返回双向链表的头节点，对于左子树需要求得尾节点和根节点链接起来
     * 对于右子树返回的头节点直接和root链接起来
     * */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        TreeNode left = null;
        if(pRootOfTree.left != null)
            left = Convert(pRootOfTree.left);
        TreeNode p = left;
        while (p != null && p.right != null)
            p = p.right;
        if(left != null) {
            System.out.println("left:" + p.val + "\t" + pRootOfTree.val);
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        TreeNode right = null;
        if(pRootOfTree.right != null)
            right = Convert(pRootOfTree.right);
        if(right != null) {
            System.out.println("right:" + right.val + "\t" + pRootOfTree.val);
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left!=null?left:pRootOfTree;
    }

}
