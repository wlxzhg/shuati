package cn.xiaozhigang.code.sword.ThirtyFiveFirstNotRepeatingChar;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.FirstNotRepeatingChar("abcdabc"));
        System.out.println(so.FirstNotRepeatingChar("abcabc"));
        System.out.println(so.FirstNotRepeatingChar("abc"));
        System.out.println(so.FirstNotRepeatingChar("abcabcd"));
    }
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.equals("")){ return -1;}

        char[] arr = str.toCharArray();
        int[] count = new int[123];
        for(int i = 0; i < 123; i++) count[i] = 0;
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(count[arr[i]] == 1)
                return i;
        }
        return -1;
    }
}
