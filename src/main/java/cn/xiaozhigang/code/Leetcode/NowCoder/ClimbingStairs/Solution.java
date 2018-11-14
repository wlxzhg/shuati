package cn.xiaozhigang.code.Leetcode.NowCoder.ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int first = 1,second = 2,tmp;
        for (int i = 3; i <= n; i++) {
            tmp = second;
            second = first + second;
            first = tmp;
        }

        return second;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        for(int i = 1; i < 11; i++) {
            System.out.println(so.climbStairs(i));
        }
    }
}
