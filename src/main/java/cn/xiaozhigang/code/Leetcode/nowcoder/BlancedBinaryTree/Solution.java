package cn.xiaozhigang.code.Leetcode.nowcoder.BlancedBinaryTree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    /**
     * 题目：判断一颗二叉树是否是平衡二叉树。
     * 思路：1.判断左右子树是否都是平衡二叉树；2.左右子树之差不超过1
     *       下面展示了两种方案，方案2比较简洁。方案1是一开始写的。
     *       方案2是学习了网友的思路。
     * */
    public boolean isBalanced2(TreeNode root) {
        return treeHeight(root) >= 0;
    }

    public int treeHeight(TreeNode root) {
        if(root == null)
            return 0;

        int right = treeHeight(root.right);
        int left = treeHeight(root.left);

        if(right >= 0 && left >= 0 && Math.abs(right - left) <= 1)
            return Math.max(right,left) + 1;
        else
            return -1;
    }


    public boolean isBalanced(TreeNode root) {
        int[] depth = new int[1];
        boolean res = isBalanced(root,depth);
        return res;
    }

    private boolean isBalanced(TreeNode root,int[] depth) {
        if(root == null) {
            depth[0] = 0;
            return true;
        }

        if(root.left == null && root.right == null) {
            depth[0] = 1;
            return true;
        }

        if(root.left == null || root.right == null) {
            boolean res = isBalanced(root.left == null?root.right:root.left,depth);
            depth[0] += 1;
            if(depth[0] > 2)
                return false;
            return res;
        }

        int[] left = new int[1];
        int[] right = new int[1];

        boolean bl = isBalanced(root.left,left);

        boolean br = isBalanced(root.right,right);

        depth[0] = 1 + Math.max(left[0],right[0]);
        // System.out.println("left:" + left[0] + " right:" + right[0]);

        if(!bl || !br)
            return false;

        return Math.abs(left[0] - right[0]) <= 1;
    }


    public static void main(String[] args) {
        Solution so = new Solution();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t3.right = t4;

        System.out.println(so.isBalanced2(null));
        // System.out.println(so.isBalanced(t4));
        // System.out.println(so.isBalanced(null));
        // System.out.println(so.isBalanced(null));

    }
}
