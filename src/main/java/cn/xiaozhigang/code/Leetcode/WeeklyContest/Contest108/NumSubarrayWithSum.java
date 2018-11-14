package cn.xiaozhigang.code.Leetcode.WeeklyContest.Contest108;

public class NumSubarrayWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int answer = 0;
        int sum = S;
        int tmpSum = 0;
        int length = A.length;
        int start = 0,end = 0;
        for(;end < length; end++) {
            tmpSum += A[end];
            if(tmpSum == sum)
                break;
        }
        if(tmpSum == sum) {
            answer = 1;
        } else {
            answer = 0;
            return answer;
        }



        return answer;
    }
}
