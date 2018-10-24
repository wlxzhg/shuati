package cn.xiaozhigang.code.Leetcode.MinimumDepthOfBinaryTree;

import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;

		Solution so = new Solution();
		System.out.println(so.run2(t1));

	}

	public int run(TreeNode root) {
		int ans = 0;
		if(root == null) return ans;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(queue.isEmpty() == false) {
			int levelSize = queue.size();
			ans++;

			for(int i = 0; i < levelSize; i++) {
				TreeNode index = queue.poll();
				if(index.left == null && index.right == null)
					return ans;
				if(index.left != null)
					queue.add(index.left);
				if(index.right != null)
					queue.add(index.right);
			}
		}
		return ans;
	}

	public int run2(TreeNode root) {
		if(root == null) return 0;

		return dfs(root);

	}

	public int dfs(TreeNode root) {
		if(root.left == null && root.right == null) return 1;

		if(root.left == null) 
			return dfs(root.right) + 1;
		else if(root.right == null) 
			return dfs(root.left) + 1;
		return Math.min(dfs(root.left),dfs(root.right)) + 1;
	}
}