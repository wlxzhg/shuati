package cn.xiaozhigang.code.sword.Permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 第28题：字符串的排列
 * 采用回溯的思想。每次固定一个位置，和他后面的交换，
 */
public class Solution {
    public static void main(String[] args) {
        List<String> res = (new Solution()).Permutation("abc");
        System.out.println(res.toString());
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.length() == 0) return res;

        Permutation(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }

    private void Permutation(char[] arr,int i,ArrayList<String> res) {
        if(i == arr.length - 1) {
            String str = String.valueOf(arr);
            if (!res.contains(str)) {
                res.add(str);
            }
        } else {
            for(int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                Permutation(arr, i + 1, res);
                swap(arr, i, j);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j]  = tmp;
    }
}
