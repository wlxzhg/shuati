package cn.xiaozhigang.code.examination.BeiKe2018.Road;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int input;
        for (int i = 0; i < n; i++) {
            input = sc.nextInt();
            sum += input;
            if (input < min) {
                min = input;
            }
        }
        System.out.print(sum - min);
    }
}
