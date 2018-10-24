package cn.xiaozhigang.code.Examination.BeiKe2018.Caclu;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述：输入N，M。N每次经过-1运算或*2运算，问最少多少次N可以变为M
 * 我的思路：暴力求解，求出N的变换路径上的所有值，与M比较，直到相等。
 *           只通过27%。
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.print(solve(N,M));
    }

    static int solve(int n, int m) {
        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(n);
        boolean flag = true;
        int ans = 0;
        while (flag) {
            int levelSize = queue.size();
            ans++;
            for(int i = 0; i < levelSize; i++) {
                int index = queue.poll();
                if(index - 1 == m || index * 2 == m)
                    return ans;
                queue.add(index - 1);
                queue.add(index * 2);
            }
        }

        return ans;
    }
}
