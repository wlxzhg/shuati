package cn.xiaozhigang.code.Leetcode.NowCoder.MaximumDepthOfBinaryTree;

import java.util.LinkedList;


/**
 * 题目：求二叉树的最大深度
 * */
public class Solution {

    //AC time:89ms  space:12032k
    //层次遍历法
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode index = queue.remove();
                if(index.left != null)
                    queue.add(index.left);
                if(index.right != null)
                    queue.add(index.right);
            }
            depth++;
        }

        return depth;
    }

    //AC time:89ms  space:11604k
    //递归法
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t2.right = t3;
        t2.left = t4;

        System.out.println(so.maxDepth2(t1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
