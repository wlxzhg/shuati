package cn.xiaozhigang.code.Leetcode.easy.IsSameTree;

import cn.xiaozhigang.code.Leetcode.util.TreeNode;
import sun.reflect.generics.tree.Tree;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(3);

        t11.left = t12;
        t11.right = t13;

        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t23 = new TreeNode(3);

        t21.left = t23;
        t21.right = t22;

        System.out.println(so.isSameTree(t11, t21));
    }


    public boolean isSameTree(TreeNode p,TreeNode q) {
       if(p == null && q == null)
           return true;
       if(p == null || q == null)
           return false;

       if(p.val != q.val)
           return false;

       return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}
