package cn.xiaozhigang.code.examination.Meituan2018.Graph;

import java.util.Arrays;
import java.util.Scanner;

class Edges {
    int start;
    int end;
    Edges(int s, int e) {
        start = s;
        end = e;
    }

    Edges(){}
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Edges[] edges = new Edges[n];
        for(int i = 0; i < n - 1; i++) {
            edges[i] = new Edges();
            edges[i].start = sc.nextInt();
            edges[i].end = sc.nextInt();
        }
        int [] parent = new int[n+1];
        Edges[] result = new Edges[n];
        int j,k;
        for(int i = 0; i < n - 1; i++) {
            j = find(parent,edges[i].start);
            k = find(parent, edges[i].end);
            if(j != k) {
                parent[j] = k;
                System.out.println(edges[i].start + "\t" + edges[i].end);
            }
            System.out.println(Arrays.toString(parent));
        }
    }

    public static int find(int[] parent,int f) {
        while (parent[f] > 0)
            f = parent[f];
        return f;
    }
}
