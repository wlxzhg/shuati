package cn.xiaozhigang.code.Examination.Qihu3602018.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = sc.nextInt();
        int[] orders = new int[n];
        for(int i = 0; i < n; i++)
            orders[i] = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n <= size) {
            for(int i : orders) {
                if(i < 0) result.add(i);
            }
        } else {
            int start = 0,end = size - 1;
            while (start < n) {

            }
        }
    }
}
