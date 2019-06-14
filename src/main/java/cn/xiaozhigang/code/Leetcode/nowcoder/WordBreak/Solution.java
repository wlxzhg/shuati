package cn.xiaozhigang.code.Leetcode.nowcoder.WordBreak;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    /**
     * 牛客网AC
     * 思路：dp[i][j]表示s[i...j]是否可以分割
     * dp[i][j] = if 存在k使得dp[i][k] && dp[k+1][j]
     * 总体时间复杂度为O(n^3)
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) return false;
        int len = s.length();
        boolean [][]dp = new boolean[len][len];

        for(int i = 0; i < len; i++) {
            if (dict.contains(s.substring(i, i + 1))) {
                dp[i][i] = true;
            }
        }

        int length = 2;
        while (length <= len) {
            for(int i = 0; i < len - length + 1; i++) {
                int j = i + length - 1;

                if (dict.contains(s.substring(i, j + 1))) {
                    dp[i][j] = true;
                } else {
                    for(int k = i; k <= j-1; k++) {
                        if(dp[i][k] && dp[k+1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
            length++;
        }
        return dp[0][len - 1];
    }

    /**
     * 改进的思路：dp[i]:s[0...i]可以被分割
     * */
    public boolean wordBreak2(String s, Set<String> dict) {
        if(s == null || s.length() == 0)
            return false;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");

        System.out.println(so.wordBreak("leetcode", dict));
        System.out.println(so.wordBreak2("leetcode", dict));

    }
}
