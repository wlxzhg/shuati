package cn.xiaozhigang.code.Leetcode.nowcoder.SearchA2DMatrix;

public class Solution {
    /**
     * 题目：有 一个二维数组。没列从小到大排序，没行从小到大排序。
     *       求指定数字是否在此数组中。
     * 思路：从右上角开始比较，若比目标大则左移一列，若小于目标则下移一行。
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        int row = matrix.length,col = matrix[0].length;

        while(i < row && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else
                i++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };

        Solution so = new Solution();

        System.out.println(so.searchMatrix(matrix,10));
        System.out.println(so.searchMatrix(matrix,2));
        System.out.println(so.searchMatrix(matrix,35));
        System.out.println(so.searchMatrix(matrix,50));
        System.out.println(so.searchMatrix(matrix,21));

    }
}
