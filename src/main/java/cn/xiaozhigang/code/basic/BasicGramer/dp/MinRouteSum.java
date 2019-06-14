package cn.xiaozhigang.code.basic.BasicGramer.dp;

public class MinRouteSum {
    /**
     * 最小路径和：
     * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达左下角的位置，路径上所有的数字累加起来
     * 就是路径和，返回所有的路径和中最小的路径和。
     */

    public static void main(String[] args) {
        int[][] arr = {
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };
        System.out.println(solve(arr));

    }

    /**
     * dp[i][j]:从(0,0)位置到达(i,j)所需要的步数
     * dp[0][j]：第一行数据为对应数字依次累加所得
     * dp[i][0]：第一列数据为对应数字依次累加所得
     * dp[i][j] = min(dp[i-1][j],dp[i][j-1])+arr[i][j]
     * */
    public static int solve(int[][] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int row = arr.length - 1,col = arr[0].length - 1;
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = arr[0][0];
        for(int j = 1; j <= col; j++)
            dp[0][j] = dp[0][j-1] + arr[0][j];
        for(int i = 1; i <= row; i++)
            dp[i][0] = dp[i-1][0] + arr[i][0];

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }

        return dp[row][col];
    }
}
