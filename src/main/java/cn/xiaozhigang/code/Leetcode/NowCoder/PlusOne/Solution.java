package cn.xiaozhigang.code.Leetcode.NowCoder.PlusOne;

import java.util.Arrays;

public class Solution {
    /**
     * 题目：数组表示一个数字，加一
     * */
    public int[] plusOne(int[] digits) {
        int carry = 1,n = digits.length;
        int[] answer = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            int tmp = digits[i] + carry;
            if(tmp >= 10) {
                answer[i] = tmp - 10;
                carry = 1;
            } else {
                answer[i] = tmp;
                carry = 0;
            }
        }
        if(carry == 1) {
            int[] newAnswer = new int[n + 1];
            newAnswer[0] = 1;
            for(int i = 0; i < n; i++) {
                newAnswer[i + 1] = answer[i];
            }
            return newAnswer;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] ans = so.plusOne(new int[] {1,1,9});

        System.out.println(Arrays.toString(ans));
    }
}
