package cn.xiaozhigang.code.examination.Exam360;

import java.util.Scanner;

public class Gold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t = 0;
        while (t < T) {
            t++;
            int n = sc.nextInt();
            int[] arr = new int[n];
//            int sum = 0;
            int[][] dp = new int[n][n];
            int[] sum = new int[n+1];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
//                sum += arr[i];
                sum[i+1] = arr[i] + sum[i];
                dp[i][i] = arr[i];
            }

            for(int span = 1; span < n; span++) {
                for(int j = 0; (span + j) < n; j++) {
                    dp[j][span + j] = sum[span + j + 1] - sum[j] -
                            Math.min(dp[j+1][span + j],dp[j][span + j - 1]);
                }
            }
            System.out.print("Case #"+t+":" + dp[0][n-1] + " " + (sum[n] - dp[0][n-1]));
            if(t < T)
                System.out.println();
        }
    }
}
