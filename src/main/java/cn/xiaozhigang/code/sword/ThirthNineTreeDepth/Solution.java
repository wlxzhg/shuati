package cn.xiaozhigang.code.sword.ThirthNineTreeDepth;

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t2.left = t3;
        t3.right = t4;

        System.out.println(so.TreeDepth(t1));
        System.out.println(so.TreeDepth(t2));

    }

    public int TreeDepth(TreeNode root) {
        return TreeDepth(root,0);
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
