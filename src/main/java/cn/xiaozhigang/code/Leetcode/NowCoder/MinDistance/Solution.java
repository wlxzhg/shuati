package cn.xiaozhigang.code.Leetcode.NowCoder.MinDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= len2; i++)
            dp[0][i] = i;
        for(int i = 1; i <= len1; i++)
            dp[i][0] = i;

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                int result1 = dp[i - 1][j] + 1;
                int result2 = dp[i][j - 1] + 1;
                int result3;
                if(arr1[i - 1] == arr2[j - 1])
                    result3 = dp[i - 1][j - 1];
                else
                    result3 = dp[i - 1][j - 1] + 1;

                dp[i][j] = Math.min(result1,result2);
                dp[i][j] = Math.min(dp[i][j],result3);
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.minDistance("abc","abcd"));
        System.out.println(so.minDistance("","abcd"));
        System.out.println(so.minDistance("",""));
        System.out.println(so.minDistance("abc","abc"));
        System.out.println(so.minDistance("a",""));
    }
}
