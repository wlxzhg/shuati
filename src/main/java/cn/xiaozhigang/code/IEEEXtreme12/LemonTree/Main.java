package cn.xiaozhigang.code.IEEEXtreme12.LemonTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        System.out.print((n - 1) * m + func(n) * s);
    }

    public static int func(int x) {
        int i = 2;
        int count = 1;
        while (i < x) {
            i <<= 1;
            count++;
        }
        return count;
    }
}
