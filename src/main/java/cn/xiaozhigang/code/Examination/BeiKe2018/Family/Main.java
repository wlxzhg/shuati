package cn.xiaozhigang.code.Examination.BeiKe2018.Family;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 输入家族关系，a,b 表示a是b的父亲
 * 给定一系列树问他们是否有祖先-后代关系
 * 我的解法：用大数组保存整个家族关系，如arr[1]=2 表示1的父亲为2
 *           对每对需要判断关系的a,b，对a进行查找祖先，看其祖先路径上是否有b，到-1结束
 * */
public class Main {
    static final int MAX_NUM = 40001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[MAX_NUM];
        int a,b;
        for(int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            arr[a] = b;
        }
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if(i != m - 1)
                System.out.println(solve(arr,a,b));
            else
                System.out.print(solve(arr,a,b));
        }
    }

    public static int solve(int[] arr,int a,int b) {
        if(isAncester(arr,a,b))
            return 1;
        if(isAncester(arr,b,a))
            return 2;
        return 0;
    }

    public static boolean isAncester(int[] arr,int a,int b) {
        int now = arr[b];
        while (now != -1 && now != a) {
            now = arr[now];
        }
        return (now == a);
    }
}
