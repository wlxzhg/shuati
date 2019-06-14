package cn.xiaozhigang.code.Leetcode.nowcoder.MaximumSubarray;

public class Solution {
    /**
     * 题目：求数组中最大连续子数组和
     * 分析：从第一个元素开始累加，如果当前累加和为一个负数，那么
     *       就应该舍弃，从零开始继续累加。累加过程记录算出的最大和。
     *       此题还可以用动态规划的方法做。设f(i)是以A[i]结尾的子数组的
     *       最大和。那么f(i) = A[i] (若f(i-1)<0) ，或f(i) = f(i-1)+A[i]
     *       (f(i-1)>0)。然后求出所有f(i)的最大值。
     * */
    public int maxSubArray(int[] A) {
        if(A == null || A.length == 0)
            return 0;

        int answer = Integer.MIN_VALUE;
        int tmp = 0;

        for(int i = 0; i < A.length; i++) {
            tmp += A[i];

            if(tmp > answer)
                answer = tmp;

            if(tmp < 0)
                tmp = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(so.maxSubArray(new int[] {-2,-1,-3,-4,-1,-2,-1,-5,4}));
        System.out.println(so.maxSubArray(new int[] {2}));


    }
}
