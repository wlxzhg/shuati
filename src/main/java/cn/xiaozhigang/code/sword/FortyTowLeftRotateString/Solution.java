package cn.xiaozhigang.code.sword.FortyTowLeftRotateString;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.LeftRotateString("hello",6));
    }

    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() <= 1 || n <= 0) return str;
        n = n % str.length();
        if(n == str.length()) return str;

        char[] chars = str.toCharArray();
        revert(chars, 0, chars.length - 1);

        int div = str.length() - n;
        revert(chars, 0, div - 1);
        revert(chars,div,str.length()-1);
        return new String(chars);
    }

    private void revert(char[] array,int i,int j) {
        if(i >= j) return;

        while (i < j) {
            swap(array,i,j);
            i++;
            j--;
        }
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
