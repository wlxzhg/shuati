package cn.xiaozhigang.code.DataStructure.String;

import java.util.Arrays;

public class KMP {
   public static void main(String[] args) {
       KMP kmp = new KMP();
       System.out.println(kmp.indexKMP("hello", "ll", 0));
   }

    void getNext(String T, int[] next) {
        int length = T.length();
        char[] arr = T.toCharArray();
        int i,j;
        i = 0;
        j = -1;
        next[i] = -1;
        while (i < length - 1) {
            if (j == -1 || arr[i] == arr[j]) {
                i++;
                j++;
                if (arr[i] != arr[j]) next[i] = j;
                else next[i] = next[j];
            }  else {
                j = next[j];
            }
        }
        System.out.println(Arrays.toString(next));
    }

    public int indexKMP(String s, String T, int pos) {
        char[] arrS = s.toCharArray();
        char[] arrT = T.toCharArray();
        int i = pos;
        int j = 0;
        int[] next = new int[arrT.length];
        getNext(T, next);
        while (i < arrS.length && j < arrT.length) {
            if(j == -1 || arrS[i] == arrT[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j >= arrT.length) {
            return i - arrT.length;
        } else
            return 0;
    }
}
