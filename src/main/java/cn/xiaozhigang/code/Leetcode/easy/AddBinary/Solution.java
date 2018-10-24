package cn.xiaozhigang.code.Leetcode.easy.AddBinary;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.addBinary("101","111"));
        System.out.println(so.addBinary("11111", "11"));
        System.out.println(so.addBinary("10101","100"));
    }


    public String addBinary(String a,String b) {
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        if(arrA.length < arrB.length) {
            char[] tmp = arrA;
            arrA = arrB;
            arrB = tmp;
        }

        int i = arrA.length  - 1,j = arrB.length - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = (arrA[i]-'0') + (arrB[j]-'0') + carry;
            if(sum >= 2) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            arrA[i] = (char)(sum + '0');
            i--;j--;
        }
        while (i >= 0) {
            int sum = (arrA[i] - '0') + carry;
            if(sum >= 2) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            arrA[i] = (char)(sum+'0');
            i--;
        }
        StringBuilder sb = new StringBuilder();
        if(carry == 1) sb.append('1');

        for(char c : arrA)
            sb.append(c);

        return sb.toString();
    }
}
