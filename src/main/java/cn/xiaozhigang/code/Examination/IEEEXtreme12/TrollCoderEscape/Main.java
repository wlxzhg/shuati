package cn.xiaozhigang.code.Examination.IEEEXtreme12.TrollCoderEscape;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问问题猜数字升级版，
 * not ac
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        int[] awser = null;
        for(int t = 0; t < times; t++) {
            int n = sc.nextInt();
            if(t == 0) {
                awser = new int[n];
            } else {
                Arrays.fill(awser,0);
            }
            System.out.println("Q " + awserToString(awser));
            int correntNumber = sc.nextInt();
        }
    }

    private static String awserToString(int[] arr) {
        String str = "";
        for(int i = 0; i < arr.length; i++) {
            str += arr[i];
            if(i != arr.length - 1)
                str += " ";
        }
        return str;
    }
}
