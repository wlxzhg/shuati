package cn.xiaozhigang.code.Examination.zhaoshangxinyongka2018.maoliang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numbersStr = input.split(" ");
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.valueOf(numbersStr[i]);
        }
        int n = sc.nextInt();

        int sum = 0;
        for (int i : numbers)
            sum += i;
        int answer = (int) Math.ceil(sum / (n));

        while (answer < sum) {
            int needTime = 0;
            for (int i = 0; i < numbers.length; i++) {
                needTime += (int)Math.ceil(numbers[i] / (answer * 1.0));
            }
            if (needTime < n)
                answer++;
            else {
                if(needTime > n)
                    answer++;
                break;
            }
        }
        System.out.print(answer);
    }
}
