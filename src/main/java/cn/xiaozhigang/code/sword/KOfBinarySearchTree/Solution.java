import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(5);
		TreeNode t3 = new TreeNode(3);
		TreeNode t7 = new TreeNode(7);
		TreeNode t2 = new TreeNode(2);
		TreeNode t4 = new TreeNode(4);
		TreeNode t6 = new TreeNode(6);
		TreeNode t8 = new TreeNode(8);

		t5.left = t3;
		t5.right = t7;
		t3.left = t2;
		t3.right = t4;
		t7.left = t6;
		t7.right = t8;

		for(int i = 1; i < 8; i++)
		System.out.println((new Solution()).KthNode2(t5,i).val);

	}

	private static ArrayList<TreeNode> orderList;

	TreeNode KthNode(TreeNode pRoot,int k) {
		orderList = new ArrayList<TreeNode>();
		dfs(pRoot);
		if(k <= orderList.size() && k >= 1)
			return orderList.get(k - 1);
		else
			return null;
	}

	void dfs(TreeNode root) {
		if(root == null) return;
		dfs(root.left);
		orderList.add(root);
		dfs(root.right);
	}

	//the second way : no recursion
	TreeNode KthNode2(TreeNode pRoot,int k) {
		if(pRoot == null || k <= 0) return null;

		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode p = pRoot;
		int i = 0;
		do {
			while(p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			i++;
			if(i == k) {
				return p;
			}
			if(p.right != null) {
				p = p.right;
			} else {
				p = null;
			}
		} while(p != null || !stack.isEmpty());

		return null;
	}
}