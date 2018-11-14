package cn.xiaozhigang.code.Leetcode.NowCoder.GrayCode;

import java.util.*;

public class Solution {
    /**
     * 题目：生成n位格雷码
     * 思路：找到生成格雷码的规律，每次讲原有格雷码倒序复制并在最高位取反（变成1）
     * 与1异或可取反，与0异或不变
     * */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(n <= 0) return ans;
        ans.add(0);
        for(int i = 1; i <= n; i++) {
            int size = ans.size();
            for(int j = size - 1; j >= 0; j--) {
                ans.add(ans.get(j) ^ (1 << (i - 1)));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        ArrayList<Integer> res = so.grayCode(1);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
