package cn.xiaozhigang.code.sword.ThirtyNineIsBlanceTree;

public class Solution {
    class help {
        int depth;
        boolean isBlance;
    }

    public boolean IsBalanced_Solution(TreeNode root) {

        return false;
    }

    private help isBalanced(TreeNode root,int depthNow) {
        
    }

    private int TreeDepth(TreeNode root,int depthNow) {
        if(root != null)
            System.out.println("val:" + root.val + ",depthNow:" + depthNow);
        if(root == null) return depthNow;
        if(root.left == null && root.right == null) {
            return depthNow + 1;
        }
        int leftDepth = TreeDepth(root.left, depthNow + 1);
        int rightDepth = TreeDepth(root.right, depthNow + 1);
        return Math.max(leftDepth, rightDepth);
    }
}
