package cn.xiaozhigang.code.examination.BeiKe2018.Duominuo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目：多米诺骨牌。每个骨牌倒下后，其后(x,x+h-1)范围内的骨牌也会倒下
 *       问每个骨牌倒下后其后有多少骨牌会倒下
 * 思路：这道题没有尝试从前往后暴力求解，是个遗憾，说不定就过了。
 * 注意点：输入骨牌的顺序不是按x排序的，最后要按输入的顺序输出答案
 * */
class Node {
    int x;
    int h;
    int count;
    int answer;
    int max;
}

public class Main {
    public static void main(String[] args) {

        int[] distance = new int[10006];
        int n;
        int [] visalbe = new int[10006];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Node[] arr = new Node[n + 1];
        arr[0] = new Node();
        arr[0].x = -10000000;
        arr[0].count = -10000000;
        System.out.println("n == " +n);
        for(int i = 1; i <= n; i++) {
            arr[i] = new Node();
            arr[i].x = sc.nextInt();
            arr[i].h = sc.nextInt();
            arr[i].count = i;
            arr[i].answer = 1;
            arr[i].max = arr[i].x + arr[i].h - 1;
            System.out.println(i);
        }
        System.out.println(1);
        Arrays.sort(arr, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        System.out.println(2);
        for(int i = n - 1; i >= 1; i--) {
            int j = i + 1;
            int max = arr[i].max;
            while (j <= n && arr[j].x <= max) {
                arr[i].answer += arr[j].answer;
                max = (int)Math.max(max,arr[j].max);
                j += arr[j].answer;

//                System.out.println(arr[j].answer);
            }
            arr[i].max = max;
            System.out.println(i);
        }
        Arrays.sort(arr, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.count - o2.count;
            }
        });
        for(int i = 1; i < n; i++)
            System.out.print(arr[i].answer + " ");
        System.out.println(arr[n].answer);
    }
}
