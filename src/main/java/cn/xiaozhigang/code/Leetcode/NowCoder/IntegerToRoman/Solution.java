package cn.xiaozhigang.code.Leetcode.NowCoder.IntegerToRoman;

/**
 * 题目：将整数转换为罗马数字
 *
 * */
public class Solution {
    public String intToRoman(int num) {
        int[] base = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] baseRoman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String ans = "";
        int pos = 0;
        while(num != 0) {
            int tmp = num / base[pos];
            for(int i = 0; i < tmp; i++)
                ans += baseRoman[pos];
            num = num - tmp * base[pos];
            pos++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.intToRoman(1000));
        System.out.println(so.intToRoman(999));
        System.out.println(so.intToRoman(1));
        System.out.println(so.intToRoman(10));
        System.out.println(so.intToRoman(51));
        System.out.println(so.intToRoman(33));
        System.out.println(so.intToRoman(3999));
    }
}
