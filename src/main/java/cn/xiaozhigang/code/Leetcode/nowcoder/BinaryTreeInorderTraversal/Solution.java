package cn.xiaozhigang.code.Leetcode.nowcoder.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    /**
     * 题目：中序遍历二叉树，非递归方法
     * 思路：利用栈。考虑中序遍历的过程即可。
     * */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode p = root;

        while(p != null || !stack.isEmpty()) {
            while(p != null) {
                stack.add(p);
                p = p.left;
            }

            if(!stack.isEmpty()) {
                p = stack.removeLast();
                answer.add(p.val);
                p = p.right;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t2.right = t3;
        t2.left = t4;
        t1.right = t5;
        t5.left = t6;

        ArrayList<Integer> in = so.inorderTraversal(t1);


        for(int i : in) {
            System.out.print(i + " ");
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}