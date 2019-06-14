package cn.xiaozhigang.code.Leetcode.nowcoder.BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    /**
     * 题目：层次遍历二叉树，从下层往上层
     * */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        if(root == null)
            return answer;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>(size);

            for(int i = 0; i < size; i++) {
                TreeNode r = queue.remove();
                level.add(r.val);
                if(r.left != null)
                    queue.add(r.left);
                if(r.right != null)
                    queue.add(r.right);
            }

            answer.add(0,level);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        ArrayList<ArrayList<Integer>> ans = so.levelOrderBottom(t1);

        for(ArrayList<Integer> i : ans) {
            System.out.println(i);
        }
    }
}
