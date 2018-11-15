package cn.xiaozhigang.code.Leetcode.NowCoder.ReverseInteger;

/**
 * 题目：求给定整数的逆序数字，如123 变为321  -123 变为-321
 * 思路：记录数字符号，若为负先变为正数，变为字符串，变为long类型
 *       判断是否大于最大int或小于最小int，若是则超出界限，否则
 *       转换为int返回
 *       关键点：负号处理、溢出处理
 * */
public class Solution {
    public int reverse(int x) {
        int flag = (x >= 0)?1:-1;
        char[] str = (""+(x * flag)).toCharArray(); //注意字符数字不包括前缀负号
        long lx = 0;
        for(int i = str.length - 1; i >= 0; i--)
            lx = (lx) * 10 + (str[i] - '0');
        lx = flag * lx;

        if(lx < (long)Integer.MIN_VALUE || lx > (long)Integer.MAX_VALUE)
            throw new IllegalArgumentException("argument out of limit!");

        return (int)lx;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.reverse(-123));
        System.out.println(so.reverse(123));
        System.out.println(so.reverse(0));
        // System.out.println(so.reverse(Integer.MAX_VALUE));
        System.out.println(so.reverse(-1233354));
        System.out.println(so.reverse(35593822));

        System.out.println(so.reverse(Integer.MIN_VALUE));

    }
}
