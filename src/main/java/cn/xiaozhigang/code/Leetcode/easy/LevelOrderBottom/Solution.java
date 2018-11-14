package cn.xiaozhigang.code.Leetcode.easy.LevelOrderBottom;

import cn.xiaozhigang.code.Leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 按层次打印二叉树，从底层向上层打印.
 * 将遍历的结果保存在List中，最后再将list反转
 * */
public class Solution {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right= t5;

        (new Solution()).levelOrderBottom(t1);
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        if(root == null) return answer;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        int levelSize = 1;
        int childLevelSize = 0;
        while (queue.isEmpty() == false) {
            LinkedList<Integer> levleList = new LinkedList<Integer>();

            for (; levelSize > 0; levelSize--) {
                TreeNode index = queue.poll();
                levleList.add(index.val);
                if (index.left != null) {
                    queue.add(index.left);
                    childLevelSize++;
                }
                if (index.right != null) {
                    queue.add(index.right);
                    childLevelSize++;
                }
            }
            levelSize = childLevelSize;
            childLevelSize = 0;
            answer.add(levleList);
        }
        //反转
        int size = answer.size();
        for(int i = 0; i < size / 2; i++) {
            List<Integer> tmp = answer.get(i);
            answer.set(i, answer.get(size - i - 1));
            answer.set(size - i - 1, tmp);
        }

        return answer;
    }
}
