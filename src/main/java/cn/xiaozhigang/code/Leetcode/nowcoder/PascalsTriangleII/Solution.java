package cn.xiaozhigang.code.Leetcode.nowcoder.PascalsTriangleII;

import java.util.ArrayList;

public class Solution {
    /**
     * 题目：生成杨辉三角的第rowIndex行
     * 思路：只使用O(n)的空间。根据公式a[i][j]=a[i-1][j-1]+a[i-1][j]每次
     *       保存一下a[i-1][j]
     * */
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        if(rowIndex < 0)
            return answer;
        answer.add(1);

        for(int i = 1; i <= rowIndex; i++) {
            int lastNumber = 1;
            for(int j = 1; j < i; j++) {
                int tmp = answer.get(j);
                answer.set(j,tmp + lastNumber);
                lastNumber = tmp;
            }
            answer.add(1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        for(int i = 0; i < 10; i++) {
            System.out.println(i+":"+so.getRow(i));
        }
    }
}
