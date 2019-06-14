package cn.xiaozhigang.code.Leetcode.nowcoder.PathSum;

/**
 * 题目：求一颗二叉树中是否有一条路径的和等于给定值
 * 思路：深度优先搜索，到达每个结点时减去当前结点的值。
 *       到达叶子结点时如果正好等于sum，说明此路径为所求。
 * */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return (sum - root.val == 0);

        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }


    public static void main(String[] args) {
        Solution so = new Solution();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);


        t1.left = t2;
        t2.right = t3;
        t2.left = t4;

        System.out.println(so.hasPathSum(t1,3));
        System.out.println(so.hasPathSum(t1,2));
        System.out.println(so.hasPathSum(t1,1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
