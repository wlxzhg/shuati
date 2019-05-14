package cn.xiaozhigang.code.Examination.IEEEXtreme12.TrollCoder;

import java.util.Scanner;

/**
 * Troll Coder
 * 问问题猜数字
 * 电脑想一个n位二进制序列，让你猜它想的是什么，最多猜n+1次。
 * 输入是一个正整数n，表示位数。输出最多有n+1行，每次输出都会
 * 得到一个新的输入表示猜对了几位。
 * 思路：第一次全0输出，记录对的位数w1
 *       第二次1000^00输出，如果结果大于w1则猜对了，否则猜错
 *       第三次在第二次结论的基础上把第二位变为1，可以判断出第二位的数字
 * AC
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] awser = new int[n];
        System.out.println("Q " + awserToString(awser));
        int correctNumber = sc.nextInt();
        for(int i = 0; i < n; i++) {
            awser[i] = 1;
            System.out.println("Q " + awserToString(awser));
            int tmp = sc.nextInt();
            if(tmp < correctNumber) {
                awser[i] = 0;
            } else if(tmp > correctNumber) {
                correctNumber = tmp;
            }
        }
        System.out.print("A " + awserToString(awser));
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
