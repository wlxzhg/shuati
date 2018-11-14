package cn.xiaozhigang.code.Leetcode.NowCoder.candy;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * 题目：给n个小朋友分糖果，每个小朋友有个评分，
 * 评分高的要比其邻居分到更多的糖果。每个人最少
 * 得到1个糖果，求最少需要多少个糖果
 *
 * 2018/11/12 暂未做出
 * */
public class Solution {
    public int candy(int[] ratings) {
        if(ratings ==  null || ratings.length == 0)
            return 0;
        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < dp.length; i++) {
            if(ratings[i] < ratings[i - 1] && dp[i] >= dp[i - 1]) {

            }
        }

        return 0;
    }
}
