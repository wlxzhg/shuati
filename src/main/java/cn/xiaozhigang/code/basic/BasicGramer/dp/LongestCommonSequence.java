package cn.xiaozhigang.code.basic.BasicGramer.dp;

public class LongestCommonSequence {
    /**
     * 题目：给定两个字符串str1和str2，返回两个字符串的最长公共子序列长度。
     * 例如，str1="1A2C3D4B56",str2="B1D23CA45B6A", "123456"或者"12C4B6"
     * */

    public static int solve(String str1,String str2) {
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
            return 0;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int len1 = arr1.length,len2 = arr2.length;

        int[][] dp = new int[len1][len2];

        return 0;
    }
}
