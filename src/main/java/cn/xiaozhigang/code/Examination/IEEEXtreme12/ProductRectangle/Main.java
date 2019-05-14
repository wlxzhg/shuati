package cn.xiaozhigang.code.Examination.IEEEXtreme12.ProductRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        System.out.println(maxSumOfSubArray(new int[]{-1,-2,-3,-4},4));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i = 0;i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < m;i++){
            arr2[i] = sc.nextInt();
        }
        int x1 = maxSumOfSubArray(arr1, n);
        int y1 = maxSumOfSubArray(arr2, m);
        for(int i = 0; i < n; i++) {
            arr1[i] = -arr1[i];
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = -arr2[i];
        }
        int x2 = maxSumOfSubArray(arr1, n);
        int y2 = maxSumOfSubArray(arr2, m);
        if(x1 * y1 > x2 * y2) {
            System.out.print(x1 * y1);
        } else
            System.out.print(x2 * y2);
    }

    public static int maxSumOfSubArray(int[] arr,int n) {
        int maxSum = Integer.MIN_VALUE;
        int tmpSum = 0;
        for(int i = 0; i < n; i++) {
            if(tmpSum <= 0)
                tmpSum = arr[i];
            else
                tmpSum += arr[i];

            if(tmpSum > maxSum)
                maxSum = tmpSum;
        }
        return maxSum;
    }
}
