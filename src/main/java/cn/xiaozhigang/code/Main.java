package cn.xiaozhigang.code;

import java.util.LinkedList;
public class Main {


    public static void main(String[] args) {
        int n = 3;
        int[][] friend = {
                {0,1,0},
                {1,0,1},
                {1,0,0}
        };

        int [] arr = new int[n];

        LinkedList<Integer> queuq1 = new LinkedList<Integer>();
        queuq1.add(0);
        arr[0] = 1;
        int size = 1;
        while (size > 0) {
            Integer now = queuq1.poll();

            for(int i = 0; i < n; i++) {
                if(friend[now][i] == 1) {
                    if(arr[i] == 1);
                }
            }
        }
    }

    public static boolean function(int[][] arr,int n) {
        int [] group = new int[n];

//        for()
        return false;
    }
}
