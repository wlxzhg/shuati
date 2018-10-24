package cn.xiaozhigang.code.Examination.Meituan2018.Graph.Tongji;

import java.util.HashMap;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int answer = 0;
        //init


        for(int l = 0; (l + k - 1) < n; l++) {
            map.clear();
            int r = l + k - 1;
            for(int i = l; i <= r; i++) {
                if(map.containsKey(arr[i]))
                    map.put(arr[i],map.get(arr[i]) + 1);
                else
                    map.put(arr[i],1);
                if(map.get(arr[i]) >= t) {
                    answer++;
                    break;
                }
            }
//            for(int i = l; i <= r; i++)
//                System.out.println(i + " : " + map.get(arr[i]));
//            System.out.println("_____________");
        }
        System.out.print(answer);
    }
}