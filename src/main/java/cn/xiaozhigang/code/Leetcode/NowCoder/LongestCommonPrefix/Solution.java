package cn.xiaozhigang.code.Leetcode.NowCoder.LongestCommonPrefix;

public class Solution {
    //超时
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        boolean flag = true;
        while(flag) {
            for(int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) i++;
        }
        if(i == 0)
            return "";
        else
            return strs[0].substring(0,i);
    }

    /**
     * 题目：求字符串数组的最长公共前缀
     * 思路：
     * */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];

        int len = strs.length;
        int i = Math.min(strs[0].length(),strs[1].length());
        for(int j = 1; j < len; j++) {
            String s1 = strs[j - 1],s2 = strs[j];
            int i1 = Math.min(s1.length(),s2.length());
            i = Math.min(i,i1);
            int k;
            for(k = 0; k < i && s1.charAt(k) == s2.charAt(k); k++);
            i = k;
            if(i == 0)
                return "";
        }
        return strs[0].substring(0,i);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.print(so.longestCommonPrefix2(new String[] {"hello"}));
    }
}
