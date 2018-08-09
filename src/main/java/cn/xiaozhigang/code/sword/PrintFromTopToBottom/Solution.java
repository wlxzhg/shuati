package cn.xiaozhigang.code.sword.PrintFromTopToBottom;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        root.left = b;
        b.right = c;

        ArrayList<Integer> result = so.PrintFromTopToBottom(root);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            int newLevelSize = 0;
            for(int i = 0; i < levelSize; i++) {
                TreeNode t = queue.removeFirst();
                result.add(t.val);
                if(t.left != null) {
                    newLevelSize++;
                    queue.add(t.left);
                }
                if(t.right != null) {
                    newLevelSize++;
                    queue.add(t.right);
                }
            }
            levelSize = newLevelSize;
        }
        return result;
    }
}
