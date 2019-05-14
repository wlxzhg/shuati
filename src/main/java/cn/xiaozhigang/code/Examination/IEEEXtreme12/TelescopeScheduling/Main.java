package cn.xiaozhigang.code.Examination.IEEEXtreme12.TelescopeScheduling;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 错误
 * */
class Watching {
    int start;
    int end;
    int desire;

    public Watching(int s, int e, int d) {
        start = s;
        end = e;
        desire = d;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Watching[] watchings = new Watching[n];
        int[] flag = new int[1001];

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int d = sc.nextInt();
            watchings[i] = new Watching(s, e, d);
        }

        for(int i = 0; i < n; i++) {
            List<Watching> confilt = new LinkedList<Watching>();
            Watching index = watchings[i];
            for(int j = index.start; j <= index.end; j++) {
                if(flag[j] != 0) {
                    confilt.add(watchings[flag[j]]);
                    j = watchings[flag[j]].end + 1;
                }
            }
            int desireSum = 0;
            for (Watching w : confilt) {
                desireSum += w.desire;
            }
            if(desireSum > index.desire)
                continue;
            for (Watching w : confilt) {
                for(int j = w.start; j <= w.end; j++)
                    flag[j] = 0;
            }
            for(int j = index.start; j <= index.end; j++) {
                flag[j] = i;
            }
        }

        int answer = 0;
        for(int i = 0; i < 1001; i++) {
            if(flag[i] != 0) {
                answer += watchings[flag[i]].desire;
                i = watchings[flag[i]].end + 1;
            }
        }
        System.out.print(answer);
    }
}
