package cn.xiaozhigang.code.Leetcode.NowCoder.PascalsTriangle;

import java.util.ArrayList;

public class Solution {
    /**
     * 题目：生成杨辉三角的前numRows行
     * 思路：递推式a[i][j]=a[i-1][j-1]+a[i-1][j]
     * */
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        if(numRows <= 0)
            return answer;
        answer.add(new ArrayList<Integer>());
        answer.get(0).add(1);

        for(int i = 1; i < numRows; i++) {
            ArrayList<Integer> line = new ArrayList<Integer>();
            ArrayList<Integer> lastLine = answer.get(i - 1);
            line.add(1);
            for(int j = 1; j < i; j++) {
                line.add(lastLine.get(j - 1) + lastLine.get(j));
            }

            line.add(1);
            answer.add(line);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        ArrayList<ArrayList<Integer>> ans = so.generate(5);

        for(ArrayList<Integer> i : ans)
            System.out.println(i);
    }
}
