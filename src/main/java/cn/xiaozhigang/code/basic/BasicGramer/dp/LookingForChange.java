package cn.xiaozhigang.code.basic.BasicGramer.dp;

public class LookingForChange {
    /**
     * 题目：
     *  给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，
     *  每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，求换
     *  钱有多少种方法。
     * */

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 20, 100, 3, 9, 10};
        int aim = 10000;

        long startTime = System.currentTimeMillis();
        //int res1 = solve(arr, aim);
        long endTime = System.currentTimeMillis();
       // System.out.println("暴力求解时间：" + (endTime - startTime) + "，结果：" + res1);

        startTime = System.currentTimeMillis();
        //int res2 = solve2(arr, aim);
        endTime = System.currentTimeMillis();
        //System.out.println("记忆化搜索：" + (endTime - startTime) + ",结果：" + res2);

        startTime = System.currentTimeMillis();
        int res3 = solve3(arr, aim);
        endTime = System.currentTimeMillis();
        System.out.println("动态规划时间：" + (endTime- startTime) + ",结果：" + res3);
    }

    public static int count = 0;

    //暴力求解法
    public static int solve(int[] arr, int aim) {
        if(arr == null || arr.length == 0 || aim <= 0) return 0;

        count = 0;
        int res = func(arr, 0, aim);
        return res;
    }

    public static int func(int[] arr,int index,int aim) {
        if(aim == 0)
            return 1;
        if(index == arr.length - 1)
            return (aim % arr[index] == 0) ? 1 : 0;
        int k = 0,res = 0;
        while (k <= aim) {
            int tmp = func(arr, index + 1, aim - k);
            res += tmp;
            count++;
//            System.out.println((count++)+ ":func(" + (index + 1) + "," + (aim - k) + ")=" + tmp);
            k += arr[index];
        }

        return res;
    }

    //记忆搜索方法
    public static int solve2(int[] arr, int aim) {
        if(arr == null || arr.length == 0 || aim <= 0)
            return 0;
        int[][] map = new int[arr.length][aim+1];

        count = 0;
        int res = func(arr, 0, aim, map);
        return res;
    }

    public static int func(int[] arr,int index,int aim,int[][]map) {
        if(aim == 0)
            return 1;
        if(index == arr.length - 1)
            return (aim % arr[index] == 0) ? 1 : 0;
        int k = 0,res = 0;
        while (k <= aim) {
            if (map[index + 1][aim - k] == 0) {
                map[index + 1][aim - k] = func(arr, index + 1, aim - k,map);
                count++;
//                System.out.println((count++) + ":func(" + (index + 1) + "," + (aim - k) + ")=");
            }

            res += map[index + 1][aim - k];
            k += arr[index];
        }

        return res;
    }

    //动态规划
    public static int solve3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }

        int[][]dp = new int[arr.length][aim+1];
        int row = arr.length - 1,col = aim;
        int k = arr[0];
        while (k <= aim) {
            dp[0][k] = 1;
            k += arr[0];
        }
        for(int i = 0; i <= row; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j - arr[i] >= 0) {
                    dp[i][j] += dp[i][j - arr[i]];
                }
            }
        }
        return dp[row][col];
    }
}
