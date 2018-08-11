//package cn.xiaozhigang.code.Examination.neteasy2018.formal.Apple;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int [] arr1 = new int[n];
//        for(int i = 0; i < n; i++)
//            arr1[i] = sc.nextInt();
//        int m = sc.nextInt();
//        int [] arr2 = new int[m];
//        for(int i = 0; i < m; i++)
//            arr2[i] = sc.nextInt();
//
//        int [] sum = new int[n];
//        sum[0] = arr1[0];
//        for(int i = 1; i < n; i++) {
//            sum[i] = arr1[i] + sum[i-1];
//        }
////        System.out.println(Arrays.toString(sum));
//        int m = sc.nextInt();
//        for(int i = 0; i < m; i++) {
//            int ask = sc.nextInt();i
//            int result = Arrays.binarySearch(sum,ask);
////            System.out.println("hhh:"+result);
//            if(result < 0)
//                result = -result;
//            else
//                result++;
////            System.out.println(result);
//            if(i != m - 1)
//                System.out.println(result);
//            else
//                System.out.println(result);
//        }
//    }
//}
