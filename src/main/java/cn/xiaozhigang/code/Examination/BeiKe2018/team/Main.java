package cn.xiaozhigang.code.Examination.BeiKe2018.team;

import java.util.*;

class Pair {
    int start;
    int end;
    int order;

    Pair(int i, int j,int o) {
        start = i;
        end = j;
        order = o;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            pairs[i] = new Pair(s,e,i+1);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                return o1.start - o2.start;
            }
        });

        int ans = 0;
        ArrayList<Integer> cols = new ArrayList<Integer>();

        for(int i = 0; i < pairs.length; i++) {
            if(isOkWithoutOne(pairs,i)) {
                ans++;
                cols.add(pairs[i].order);
            }
        }
        System.out.print(ans);
        Collections.sort(cols);
        for(int i = 0; i < ans; i++)
            System.out.print(" " + cols.get(i));
    }

    private static boolean isOkWithoutOne(Pair[] pairs,int out) {
        boolean flag = true;
        for(int i = 0; i < pairs.length - 1; i++) {
            if(i == out) continue;
            int span = 1;
            if((i + 1) == out) {
                span = 2;
            }
            if(i + span < pairs.length && pairs[i].end > pairs[i + span].start) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
