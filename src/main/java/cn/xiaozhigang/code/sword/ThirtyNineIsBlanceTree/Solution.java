package cn.xiaozhigang.code.sword.ThirtyNineIsBlanceTree;

import java.util.Map;

/**
 * 判断一颗二叉树是否是平衡二叉树
 * 平衡二叉树：左右子树深度之差不超过1的二叉树
 * 判断：左右子树都是平衡二叉树且深度之差不超过1
 * 实际上是一次后续遍历，这里的一个关键是用返回值为-1表示子树不平和，
 * 返回值大于-1时表示子树平衡且为子树深度
 * */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        System.out.println(so.IsBalanced_Solution(t1));
    }


    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return false;

        return subTreeDepth(root) == -1?false:true;
    }

    private int subTreeDepth(TreeNode root) {
        if(root == null) return 0;
        int left = 0,right = 0;
        if(root.left != null)
            left = subTreeDepth(root.left);
        if(root.right != null)
            right = subTreeDepth(root.right);

        if(left == -1) return -1;
        if(right == -1) return -1;

        return Math.abs(left - right) <= 1?Math.max(left,right)+1:-1;
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

    }
}
