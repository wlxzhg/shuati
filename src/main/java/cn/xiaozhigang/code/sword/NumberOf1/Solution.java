package cn.xiaozhigang.code.sword.NumberOf1;

public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }

    public static void main(String [] args) {
        Solution so = new Solution();
        System.out.println(so.NumberOf1(1));
        System.out.println(so.NumberOf1(0));
        System.out.println(so.NumberOf1(-1));
        System.out.println(so.NumberOf1(15));
        System.out.println(so.NumberOf1(100));

    }
}
