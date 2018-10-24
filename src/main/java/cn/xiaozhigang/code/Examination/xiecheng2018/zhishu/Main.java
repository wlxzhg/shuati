package cn.xiaozhigang.code.Examination.xiecheng2018.zhishu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPrime(25));

        System.out.println(false | false);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long sum = 0;
        for(int index = 1; index < N; index++) {
            if(isPrime(index + index-1))
                sum += (index + index - 1);
        }
        System.out.print(sum);
    }

    public  static  boolean isPrime(int n) {
        double n_sqrt;
        if(n == 2 || n == 3) return true;
        if(n % 6 != 1 && n%6 != 5) return false;
        n_sqrt = Math.sqrt(n);
        for(int i = 5; i <= n_sqrt; i+= 6) {
            if(n % i == 0 | n %(i + 2)==0) return false;
        }
        return true;
    }
}
