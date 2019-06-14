package cn.xiaozhigang.code.examination.IEEEXtreme12.BitSoccer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int q = sc.nextInt();
            System.out.print("Yes");
            if (i != t - 1) {
                System.out.println();
            }
        }
    }
}
