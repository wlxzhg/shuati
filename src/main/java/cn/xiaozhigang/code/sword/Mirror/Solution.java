package cn.xiaozhigang.code.sword.Mirror;

public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null) return;

        if(root.left == null && root.right == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        Mirror(root.right);
        Mirror(root.left);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;

        (new Solution()).Mirror(a);
        System.out.println(a.val);
        System.out.println(a.left.val);
        System.out.println(a.right.val);
    }
}
