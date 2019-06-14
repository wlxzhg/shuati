package cn.xiaozhigang.code.examination.Qihu3602018.Flower;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        int[] awser = new int[n];
        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            set.add(t);
            awser[i] = set.size();
        }
        long q = sc.nextInt();
        for(long i = 0; i < q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if(start == end)
                System.out.print(0);
            else {
                if(start > 1) {
                    int result = awser[end-1]-awser[start-2];
                    if(result == 0) result++;
                    System.out.print(result);
                }
                else
                    System.out.print(awser[end-1]);
            }
            if(i != q-1)
                System.out.println();
        }
    }
}
