package cn.xiaozhigang.code.Leetcode.NowCoder.RotateImage;

import java.util.Arrays;

public class Solution {
    /**
     * 题目：将二维数组顺时针旋转90度。
     * 思路：我的思考过程是，直接旋转非常麻烦，能不能分步骤做？
     *      就试了试沿对角线反转，发现离最后的结果只差一次对折，就做出来了。
     * */
    public void rotate(int[][] matrix) {
        if(matrix == null) return;

        int row = matrix.length;

        if(row == 1)
            return;

        for(int i = 1; i < row; i++) {
            for(int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }


        for(int i = 0; i < row; i++) {
            for(int j = 0; j < row / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][row - 1 - j];
                matrix[i][row - 1 - j] = tmp;
            }
        }

        return;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int[][] array2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] array3 = {
                {1,2},
                {3,4}
        };

        int[][] array4 = {
                {1}
        };

        Solution so = new Solution();
        so.rotate(array4);

        System.out.println("----------------");
        for(int[] a : array4) {
            System.out.println(Arrays.toString(a));
        }
    }
}
