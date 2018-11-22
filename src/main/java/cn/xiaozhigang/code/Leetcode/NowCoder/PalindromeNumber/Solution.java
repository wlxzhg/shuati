package cn.xiaozhigang.code.Leetcode.NowCoder.PalindromeNumber;

public class Solution {
    /**
     * 题目：判断一个数是否是回文数，要求不能使用额外空间。
     * 思路：排除了转换为字符串的解法。考虑求反转数字的解法。
     *       需要考虑数字溢出问题，使用long类型数字。
     * */
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        long rev = 0;
        long y = (long)x;
        while(y > 0) {
            rev =rev * 10 +  y % 10;
            y /= 10;
        }

        if(rev > Integer.MAX_VALUE)
            return false;

        return ((int)rev == x);
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.isPalindrome(100));
        System.out.println(so.isPalindrome(121));
        System.out.println(so.isPalindrome(-111));
        System.out.println(so.isPalindrome(111));
        System.out.println(so.isPalindrome(1));
        System.out.println(so.isPalindrome(11));
        System.out.println(so.isPalindrome(34566543));
        System.out.println(so.isPalindrome(23456432));

    }
}
