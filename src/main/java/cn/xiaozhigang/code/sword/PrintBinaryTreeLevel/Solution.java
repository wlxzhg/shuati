package cn.xiaozhigang.code.sword.PrintBinaryTreeLevel;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution so = new Solution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t3.left =t4;
		t4.right = t5;
		t4.left = t6;
		t2.left = t7;

		ArrayList<ArrayList<Integer>> ans = so.Print(t1);
		for(ArrayList<Integer> level : ans) {
			System.out.println(level.toString());
		}

	}

	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null) return ans;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(pRoot);

		while(!queue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			int levelSize = queue.size();
			for(int i = 0; i < levelSize; i++) {
				TreeNode index = queue.poll();
				level.add(index.val);
				if(index.left != null) queue.add(index.left);
				if(index.right != null) queue.add(index.right);
			}
			ans.add(level);
		}

		return ans;
	}
}