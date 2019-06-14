package cn.xiaozhigang.code.Leetcode.nowcoder.SameTree;

public class Solution {
    /**
     * 题目：判断两颗二叉树是否结构和对应结点值都相同。
     * 思路：递归判断，先判断当前结点值是否完全一致，再判断其左右子树是否完全一致
     * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //注意这里对p,q为null不为null的四种组合的处理
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    public static void main(String[] args) {
        Solution so = new Solution();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);

        t1.left = t2;
        t2.left = t3;

        t5.left = t6;
        t6.left = t7;
        t5.right = t8;

        System.out.println(so.isSameTree(t1,t5));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
