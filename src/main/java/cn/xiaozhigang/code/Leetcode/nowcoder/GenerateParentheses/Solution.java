package cn.xiaozhigang.code.Leetcode.nowcoder.GenerateParentheses;

import java.util.ArrayList;

public class Solution {
    /**
     * 题目：生成括号。生成n对括号所有可能的组合。
     * 思路：自己想的。先固定n个左括号，把n个右括号插入进去。
     *       第一个(和第二个(之间有0-1个).第2个(和第3个(之间有0-2个)
     *       以此类推，注意最后一个左括号后至少有一个右括号。
     * */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        int[] arr = new int[n + 1]; //arr[i]表示第i个左括号后紧跟几个右括号，i从1开始
        dfs(ans,arr,1,n);

        return ans;
    }

    private static int count = 0;
    private void dfs(ArrayList<String> ans,int[] arr,int i,int left) {
        count++;
        if(left <= 0) return;

        int n = arr.length - 1;
        if(i == n) {
            arr[n] = left;
            ans.add(buildParenthesis(arr));
            return;
        }

        //j表示第i个位置的右括号数，不能超过left（因为要留一个放在最后）
        //不能超过i-(n-left)，避免()())(()的情况
        for(int j = 0; j <= (i - (n - left)) && j < left; j++) {
            arr[i] = j;
            dfs(ans,arr,i + 1,left - j);
        }
    }

    private String buildParenthesis(int[] arr) {
        StringBuilder sb = new StringBuilder();

        int n = arr.length - 1;
        for(int i = 1; i <= n; i++) {
            sb.append('(');
            for(int j = 0; j < arr[i]; j++)
                sb.append(')');
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Solution so = new Solution();

        ArrayList<String> ans = so.generateParenthesis(10);
        for(String s : ans) {
            System.out.println(s);
        }

        System.out.println(count);
    }
}
