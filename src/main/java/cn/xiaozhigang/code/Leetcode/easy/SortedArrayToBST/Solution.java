package cn.xiaozhigang.code.Leetcode.easy.SortedArrayToBST;

import cn.xiaozhigang.code.Leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：将有序数组转换为高度平衡的二叉搜索树，使其每个节点的左右两个
 * 子树的高度差的绝对值不超过1
 * 思路：选择数组中间的元素作为根节点，其左边的子数组构成左子树，右边的
 * 子数组构成右子树。
 * */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode root = so.sortedArrayToBST(new int[] {-10,-3,0,5,9});
        ArrayList<Integer> pre = TreeNode.getPreOrder(root);
        ArrayList<Integer> in = TreeNode.getInOrder(root);

        System.out.println(Arrays.toString(pre.toArray()));
        System.out.println(Arrays.toString(in.toArray()));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if(i > j){ return null;}

        int center = (i + j) / 2;
        TreeNode index = new TreeNode(nums[center]);
        index.left = sortedArrayToBST(nums, i, center - 1);
        index.right = sortedArrayToBST(nums, center + 1, j);

        return index;
    }
}

