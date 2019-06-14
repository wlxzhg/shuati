package cn.xiaozhigang.code.basic.BasicGramer.dp;

public class LongestSequence {
    /**
     * 求数组中最长递增子序列。给定数组arr，返回arr的最长递增子序列长度。
     * 比如arr=[2,1,5,3,6,4,8,9,7]，最长递增子序列为[1,3,4,8,9],所以返回
     * 这个子序列的长度为5.
     * */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,0,6,7,8};
        System.out.println(sovle(arr));

    }


    public static int sovle(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        if(arr.length == 1)
            return 1;

        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;

        int res = 0;
        for (int i = 1; i < len; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && dp[j] > max)
                    max = dp[j];
            }
            dp[i] = max + 1;
            if(dp[i] > res)
                res = dp[i];
            System.out.println(i + ":" + dp[i]);
        }
        return res;
    }
}
