package cn.xiaozhigang.code.Leetcode.NowCoder.SingleNumber;

/**
 * 数组中只有一个数字出现一次，其它数字均出现两次求出现一次的这个数字
 * */
public class Solution {
    //全部数字异或的结果即为答案
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0)
            return 0;

        int ans = A[0];
        for(int i = 1; i < A.length; i++) {
            ans ^= A[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.singleNumber(new int[] {}));
    }
}
