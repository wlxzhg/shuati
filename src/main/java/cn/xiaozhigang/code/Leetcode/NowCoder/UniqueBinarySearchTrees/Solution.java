package cn.xiaozhigang.code.Leetcode.NowCoder.UniqueBinarySearchTrees;

public class Solution {
    /**
     * 题目：求结点为1-n的二叉搜索树共有多少种不同的形态。
     * 思路：考虑直接求f(n)不好求，是否可以分解成子问题求解。
     *       那么f(n)和谁相关呢？对于一颗根节点确定的二叉搜索树，
     *       其形态树等于左子树的形态树乘以右子树的形态树。
     *       对于1-n中一个确定根结点r，其左右子树结点个数也是确定的。
     *       （根据r中1-n中的位置）。则用动态规划可求解
     * 备注：参考网友思路后自己实现
     * */
    public int numTrees(int n) {
        int[] dp = new int[n+2];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                dp[i] += (dp[j] * dp[i - 1 - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        for(int i = 1; i < 10; i++)
            System.out.println(so.numTrees(i));
    }
}
