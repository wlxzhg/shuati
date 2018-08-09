package cn.xiaozhigang.code.sword.FindPath;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    private static ArrayList<ArrayList<Integer>> result = null;
    private static int current = 0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        result = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        current = 0;
        FindPath(root,target,stack);
        return result;
    }

    private void FindPath(TreeNode root, int target, LinkedList<TreeNode> stack) {
        if(root == null) return;
        current = current + root.val;
        stack.add(root);
        boolean isLeaf = (root.left == null && root.right == null);
        if(isLeaf && current == target) {
            ArrayList<Integer> oneway = new ArrayList<Integer>();
            for(TreeNode treeNode : stack)
                oneway.add(treeNode.val);
            result.add(oneway);
        }

        if(root.left != null) {
            FindPath(root.left,target,stack);
        }
        if(root.right != null) {
            FindPath(root.right,target,stack);
        }

        stack.removeLast();
        current -= root.val;
    }
}
