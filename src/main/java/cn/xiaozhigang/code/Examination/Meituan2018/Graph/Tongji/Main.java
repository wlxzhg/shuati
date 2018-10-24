package cn.xiaozhigang.code.Examination.Meituan2018.Graph.Tongji;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
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
        int lastOne = -1;
        for(int i = 0; i <= k - 1; i++) {
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i]) + 1);
            else
                map.put(arr[i],1);
            if(map.get(arr[i]) >= t) {
                answer++;
                lastOne = i;
            }
        }

        for(int l = 1; (l + k - 1) < n; l++) {
            int r = l + k - 1;
            if(map.containsKey(arr[l - 1]))
                map.put(arr[l - 1],map.get(arr[l - 1]));
            if(map.containsKey(arr[r]))
                map.put(arr[r],map.get(arr[r]));
            else
                map.put(arr[r],1);

            if(lastOne >= l && lastOne <= r)
                answer++;
            else {
                for(int i = l; i <= r; i++) {
                    if(map.get(arr[i]) >= t) {
                        answer++;
                        lastOne = i;
                    }
                }
            }

//            for(int i = l; i <= r; i++)
//                System.out.println(i + " : " + map.get(arr[i]));
//            System.out.println("_____________");
        }
        System.out.print(answer);
    }
}
