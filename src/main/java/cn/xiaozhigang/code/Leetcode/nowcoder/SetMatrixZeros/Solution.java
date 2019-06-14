package cn.xiaozhigang.code.Leetcode.nowcoder.SetMatrixZeros;

import java.util.Arrays;

public class Solution {
    /**
     * 题目：给定一个数组matrix，如果matrix[i][j]==0则把其所在行列所有元素都置为0
     * 思路：关键考虑置为0行列中还存在其他为0的元素怎么保存。
     *       只需遍历数组，记录哪些列和哪些行需要置为0.
     *       思路1：使用额外的两个数组保存
     *       思路2：不使用额外空间，直接使用原数组第一行和第一列保存。
     *       但是要注意第一行、第一列是否需要置为0，要先记录一下，免得被覆盖。
     * */

    //思路2
    public void setZeroes2(int[][] matrix) {
        boolean row = false,col = false;
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    //思路1
    public void setZeroes(int[][] matrix) {
        int row = matrix.length,col = matrix[0].length;

        boolean[] tmp1 = new boolean[row];
        boolean[] tmp2 = new boolean[col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 0) {
                    tmp1[i] = true;
                    tmp2[j] = true;
                }
            }
        }

        for(int i = 0; i < row; i++) {
            if(tmp1[i]) {
                for(int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < col; j++) {
            if(tmp2[j]) {
                for(int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        int[][] matrix = {
                {0,1,2,3,4},
                {2,3,0,1,8},
                {1,2,3,4,5}
        };

        so.setZeroes2(matrix);

        for(int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
    }
}
