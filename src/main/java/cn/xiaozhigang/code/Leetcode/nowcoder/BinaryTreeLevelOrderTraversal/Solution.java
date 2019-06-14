package cn.xiaozhigang.code.Leetcode.nowcoder.BinaryTreeLevelOrderTraversal;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    /**
     * 题目：二叉树层次遍历
     * 思路：用栈保存没一层的结点
     * */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        if(root == null)
            return answer;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode index = queue.remove();
                level.add(index.val);
                if(index.left != null)
                    queue.add(index.left);
                if(index.right != null)
                    queue.add(index.right);
            }

            answer.add(level);
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

        t1.left = t2;
        t2.right = t3;
        t2.left = t4;
        t3.left = t5;

        ArrayList<ArrayList<Integer>> ans = so.levelOrder(t1);

        for(ArrayList<Integer> i : ans) {

            System.out.println(i);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
