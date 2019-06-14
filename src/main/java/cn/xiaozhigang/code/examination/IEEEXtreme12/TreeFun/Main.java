package cn.xiaozhigang.code.examination.IEEEXtreme12.TreeFun;

import java.util.Scanner;

class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    int val;
    int number;

    public TreeNode(int number) {
        this.number = number;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeNode[] treeNodes = new TreeNode[n];
        for(int i = 1; i < n; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            if(treeNodes[p] == null) {
                treeNodes[p] = new TreeNode(p);
            }
        }

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //发现目标节点则通过返回值标记该子树发现了某个目标结点
        if(root == null || root == p || root == q) return root;
        //查看左子树中是否有目标结点，没有为null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //查看右子树是否有目标节点，没有为null
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //都不为空，说明做右子树都有目标结点，则公共祖先就是本身
        if(left!=null&&right!=null) return root;
        //如果发现了目标节点，则继续向上标记为该目标节点
        return left == null ? right : left;
    }
}
