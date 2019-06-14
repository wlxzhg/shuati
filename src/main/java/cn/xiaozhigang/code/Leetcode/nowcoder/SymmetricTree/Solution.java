package cn.xiaozhigang.code.Leetcode.nowcoder.SymmetricTree;

import java.util.LinkedList;

public class Solution {
    /**
     * 题目：判断一颗二叉树是否是镜像二叉树。结构左右对称，且对应数值相等
     * 思路：1.递归
     *           一棵树是镜像的，那么它的左右子树对称且分别也是镜像的。
     *           递归判断两棵树是否对称且分别保持镜像性质
     *
     *       2.非递归
     *          进行层级遍历，需要比较是否对称的'根'结点放在相邻的位置。
     *          每次取出两个结点判断是否值相等，是否子树对称。
     * */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode r1,TreeNode r2) {
        if(r1 == null && r2 == null) return true;

        if(r1 != null && r2 != null) {
            return (r1.val == r2.val) && isSymmetric(r1.right,r2.left) && isSymmetric(r1.left,r2.right);
        }

        return false;
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            TreeNode r1 = queue.remove();
            TreeNode r2 = queue.remove();
            if(r1 == null && r2 == null)
                continue;
            else if(r1 != null && r2 != null) {
                if(r1.val != r2.val)
                    return false;
                queue.add(r1.left);
                queue.add(r2.right);
                queue.add(r1.right);
                queue.add(r2.left);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(1);

        t1.left = t2; t1.right = t3;
        t2.left = t4; t3.right = t5;
        t4.right = t6; t5.left = t7;

        System.out.println(so.isSymmetric2(t1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}