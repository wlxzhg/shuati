package cn.xiaozhigang.code.Basic.DP;

import java.util.Arrays;

public class StringVary {
    /**
     * 给定两个字符串str1和str2，再给定三个整数ic,dc和rc，分别代表插入、
     * 删除和替换一个字符的代价。返回将str1编辑成str2的最小代价。
     */

    public static int sovle(String s1, String s2, int ic, int dc, int rc) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int N = str1.length,M = str2.length;

        //dp[i][j]表示s1[0..i-1]编辑为s2[0..j-1]的最小代价
        int[][] dp = new int[N+1][M+1];

        //空串变为s2[0..j-1]
        for(int j = 1; j <= M; j++) {
            dp[0][j] = dp[0][j - 1] + ic;
        }

        //s1[0..i-1]变为空串
        for(int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dc;
        }

        //普通位置四种情况，选最小的
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                int res1 = dp[i - 1][j] + dc;
                int res2 = dp[i][j - 1] + ic;
                int res3;
                if (str1[i - 1] == str2[j - 1]) {
                    res3 = dp[i - 1][j - 1];
                } else {
                    res3 = dp[i - 1][j - 1] + rc;
                }

                dp[i][j] = Math.min(res1, res2);
                dp[i][j] = Math.min(res3, dp[i][j]);
            }
        }

        for(int i = 0; i <= N; i++)
        System.out.println(Arrays.toString(dp[i]));

        return dp[N][M];
    }

    public static void main(String[] args) {
        System.out.println(sovle("ab12cd3", "abcdf", 5, 3, 2));
    }
}
