package cn.xiaozhigang.code.Leetcode.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    //输出先序序列--非递归先序遍历二叉树
    public static ArrayList<Integer> getPreOrder(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode p = root;
        while (p != null || stack.isEmpty() == false) {
            while (p != null) {
                answer.add(p.val);
                stack.addFirst(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.poll();
                p = p.right;
            }
        }

        return answer;
    }

    //输出中序序列--非递归中序遍历二叉树
    public static ArrayList<Integer> getInOrder(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.addFirst(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.poll();
                answer.add(p.val);
                p = p.right;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right= t5;

        List<Integer> pre = getPreOrder(t1);
        for (int i : pre) {
            System.out.print(i + " ");
        }
        System.out.println();

        List<Integer> in = getInOrder(t1);
        for (int i : in) {
            System.out.print(i + " ");
        }
        System.out.println();
//        System.out.println(getPreOrder(t1));
    }
}
