package cn.xiaozhigang.code.Examination.Qihu3602018.live;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long maxX, maxY, minX, minY;
        maxX = maxY = Integer.MIN_VALUE;
        minX = minY = Integer.MAX_VALUE;
        int x,y;
        for (int i = 0; i < N; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            if(x > maxX) maxX = x;
            if(x < minX) minX = x;
            if(y > maxY) maxY = y;
            if(y < minY) minY = y;
        }
        long length1 = maxX - minX;
        long length2 = maxY - minY;
        long length = (length1 > length2)?length1:length2;
        System.out.print(length * length);
    }
}
