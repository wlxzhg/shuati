package cn.xiaozhigang.code.Leetcode.nowcoder.SpiralMatrixII;

import java.util.Arrays;

public class Solution {
    /**
     * 题目：按螺旋的形状输出一个n*n的数组，元素从1到n*n。
     * 思路：直接求解。注意边界条件即可。
     * */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int number = 1,i = 0,j = 0,windth = n;


        while(windth >= 1) {
            if(windth == 1) {
                result[i][j] = number;
                break;
            }
            for(int k = 0; k < windth - 1; k++)
                result[i][j + k] = (number++);
            j = j + windth - 1;

            for(int k = 0; k < windth - 1; k++)
                result[i + k][j] = (number++);
            i = i + windth - 1;

            for(int k = 0; k < windth - 1; k++)
                result[i][j - k] = (number++);
            j = j - (windth - 1);

            for(int k = 0; k < windth - 1; k++)
                result[i - k][j] = (number++);
            i = i - (windth - 2);
            j++;

            windth -= 2;
        }


        return result;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        for(int i = 1; i <= 10; i++) {
            int[][] res = so.generateMatrix(i);

            for(int[] a : res) {
                System.out.println(Arrays.toString(a));
            }
        }

    }
}
