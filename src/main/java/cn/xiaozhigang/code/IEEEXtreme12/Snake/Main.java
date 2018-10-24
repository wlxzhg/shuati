package cn.xiaozhigang.code.IEEEXtreme12.Snake;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
//        int[] arr1 = positionRev(11, 4);
//        System.out.println(arr1[0] + " " + arr1[1]);

        Scanner sc = new Scanner(System.in);
        int board = sc.nextInt();
        int maxSteps = board * board;

        int player= sc.nextInt();
        int[] arrPlayer = new int[player];
        int[] arrPlayerNumber = new int[player];
        int[] arrPlayerResult = new int[player];

        for(int i = 0; i< player;i++){
            arrPlayer[i] = 0;
            arrPlayerNumber[i] = i;
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int j = 0; j < 2; j++) {
            int snake = sc.nextInt();
            for(int i = 0; i< snake;i++){
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();

                int start = position(x1,y1,board);
                int end = position(x2,y2,board);

                map.put(start,end);
            }
        }
//        Set<Map.Entry<Integer, Integer>> set1 = map.entrySet();
//        for (Map.Entry<Integer, Integer> s : set1) {
//            System.out.println(s.getKey() + ":" + s.getValue());
//        }


        int dice = sc.nextInt();
        for(int i = 0; i < dice; i++){
            int first = sc.nextInt();
            int second = sc.nextInt();

            if(player == 0)
                continue;
            int index = i % player;
            arrPlayer[index] += (first + second);
            if(map.containsKey(arrPlayer[index])) {
                arrPlayer[index] = map.get(arrPlayer[index]);
            }
            arrPlayerResult[arrPlayerNumber[index]] = arrPlayer[index];

            if(arrPlayer[index] > maxSteps) {
//                System.out.println(arrPlayerNumber[index] + 1 + " winner");
                for(int j = i + 1; j < player; j++) {
                    arrPlayer[j-1] = arrPlayer[j];
                    arrPlayerNumber[j - 1] = arrPlayerNumber[j];
                }
                player--;
            }
        }

//        for(int i = 0; i < player; i++) {
//            System.out.println(arrPlayerNumber[i] + " " + arrPlayer[i]);
//        }
        for(int i = 0; i < arrPlayerResult.length; i++) {
            if(arrPlayerResult[i] > maxSteps) {
                System.out.print((i + 1) + " winner");
            } else {
                int[] arr = positionRev(arrPlayerResult[i],board);
                System.out.println((i + 1) + " " + arr[0] + " " + arr[1]);
            }
//                System.out.print((i + 1) + " " + arrPlayerResult[i]);
            if (i != arrPlayerResult.length - 1) {
                System.out.println();
            }
        }
    }

    public static int position(int x,int y,int n) {
        int answer = (y - 1) * 4;
        if((y & 1) == 1) {
            answer += x;
        } else {
            answer += (n - x + 1);
        }
        return answer;
    }

    public static int[] positionRev(int pos, int n) {
        if(pos == 0) {
            return new int[] {0,1};
        } else if(pos == n * n + 1) {
            return new int[] {0,n};
        }

        int x = (pos - 1) / n + 1;

        int yu = pos % n;
        if(yu == 0)
            yu = n;
        int y;
        if(x % 2 == 1)
            y = yu;
        else
            y = n - yu + 1;

        return new int[] {y,x};
    }
}

