package cn.xiaozhigang.code.Leetcode.NowCoder.RemoveDuplicatesFromSortedArrayII;

import java.util.Arrays;

public class Solution {
    /**
     * 题目：给定一次数组，求掉数组中的重复元素，但每个元素最多允许出现两次。
     * 思路：从前往后遍历，遇到不和前一个数一样的，说明需要保留。和前一个数一样的，
     *      就开始计数，前两个保留之后的跳过。
     * */
    public int removeDuplicates(int[] A) {
        if(A == null)
            return 0;
        if(A.length <= 1)
            return A.length;
        int i = 0,j = 1,n = A.length,count = 0;
        while(j < n) {
            if(A[i] != A[j]) {
                A[++i] = A[j];
                count = 0;
            } else {
                count++;
                if(count < 2) {
                    A[++i] = A[j];
                }
            }
            j++;
        }
        return (i + 1);
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        int[] a = {0,0,1,1,1,1,2,3,3};
        System.out.println(so.removeDuplicates(a));

        System.out.println(Arrays.toString(a));
    }
}
