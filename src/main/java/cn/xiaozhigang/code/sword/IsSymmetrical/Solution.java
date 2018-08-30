package cn.xiaozhigang.code.sword.IsSymmetrical;

public class Solution {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t2.right = t3;
        System.out.println((new Solution()).isSymmetrical(t1));
    }

    boolean isSymmetrical2(TreeNode pRoot) {
        if(pRoot == null) return true;
        return compare(pRoot.left,pRoot.right);
    }

    boolean compare(TreeNode left,TreeNode right) {
        if(left == null) return right == null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return (compare(right.left,left.right)) && (compare(right.right,left.left));
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs1(pRoot, sb1);
        dfs2(pRoot, sb2);
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        return (sb1.toString().equals(sb2.toString()));
    }

    private void dfs1(TreeNode root,StringBuilder sb) {
        sb.append((root == null)?"#":root.val);
        if(root != null) {
            dfs1(root.left,sb);
            dfs1(root.right,sb);
        }
    }

    private void dfs2(TreeNode root,StringBuilder sb) {
        sb.append((root == null)?"#":root.val);
        if(root != null) {
            dfs1(root.right,sb);
            dfs1(root.left,sb);
        }
    }
}
