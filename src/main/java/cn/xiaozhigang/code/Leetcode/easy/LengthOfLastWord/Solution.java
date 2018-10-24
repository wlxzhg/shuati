package cn.xiaozhigang.code.Leetcode.easy.LengthOfLastWord;


/**
 * 题目：请一个字符串中最后一个单词的长度
 * 思路：从后往前遍历，找到第一个非空字符或字符串开头即为单词结尾，找到下一个空字符或头部 为单词开头
 * */
public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.lengthOfLastWord("hello world"));
        System.out.println(so.lengthOfLastWord(" wor "));
        System.out.println(so.lengthOfLastWord("hello"));
        System.out.println(so.lengthOfLastWord("h"));
        System.out.println(so.lengthOfLastWord(" h"));
        System.out.println(so.lengthOfLastWord("  "));
    }

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] strs = s.toCharArray();
        int last = strs.length - 1;
        while (last >= 0 && strs[last] == ' ')
            last--;
        int start = last;
        while(start >= 0 && strs[start] != ' ')
            start--;
        return last - start;
    }
}
