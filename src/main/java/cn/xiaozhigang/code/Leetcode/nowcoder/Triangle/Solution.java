package cn.xiaozhigang.code.Leetcode.nowcoder.Triangle;

import java.util.*;

/**
 * 题目：给定一个三角形，找出自顶向下的最小路径和，每一步都只能移动到
 * 下一行中相邻的点上
 * */
public class Solution {
    /**
     * 动态规划
     * 使用O(n*n)的额外空间，存储到达每个位置的最小路径和。
     * 找出最后一行中的最小值
     * */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][];
        for(int i = 0; i < row; i++)
            dp[i] = new int[i + 1];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < row; i++) {
            ArrayList<Integer> thisLine = triangle.get(i);
            dp[i][0] = thisLine.get(0) + dp[i - 1][0];
            for(int j = 1; j < i; j++) {
                dp[i][j] = thisLine.get(j) + Math.min(dp[i - 1][j],dp[i - 1][j - 1]);
            }
            dp[i][i] = thisLine.get(i) + dp[i - 1][i - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int i : dp[row - 1]) {
            if(min > i)
                min = i;
        }
        return min;
    }

    /**
     * 优化空间复杂度
     * 使用O(N)的空间记录当前已知的到列的最短距离
     * */
    public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row];
        int[] tmpDp = new int[row];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < row; i++) {
            ArrayList<Integer> thisLine = triangle.get(i);

            tmpDp[0] = thisLine.get(0) + dp[0];
            tmpDp[i] = thisLine.get(i) + dp[i - 1];
            for(int j = 1; j < i; j++) {
                tmpDp[j] = thisLine.get(j) + Math.min(dp[j],dp[j - 1]);
            }
            for(int k = 0; k < row; k++)
                dp[k] = tmpDp[k];
        }
        int ans = Integer.MAX_VALUE;
        for(int i : dp) {
            if(ans > i)
                ans = i;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] trian = {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 4; i++) {
            ArrayList<Integer> line = new ArrayList<Integer>();

            for(int j = 0; j <= i; j++)
                line.add(trian[i][j]);
            triangle.add(line);
        }

        System.out.println(so.minimumTotal2(triangle));
    }
}
