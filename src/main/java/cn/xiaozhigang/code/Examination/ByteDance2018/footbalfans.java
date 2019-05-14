package cn.xiaozhigang.code.Examination.ByteDance2018;

import java.util.Scanner;

/**
 * AC��
 * ��Ŀ��
 * */
public class footbalfans {
    private static int M,N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = 10;
        N = 10;
        int[][] arr = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,0,1,0,0,0},
                {0,1,0,0,0,0,0,1,0,1},
                {1,0,0,0,0,0,0,0,1,1},
                {0,0,0,1,1,1,0,0,0,1},
                {0,0,0,0,0,0,1,0,1,1},
                {0,1,1,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0},
                {0,0,1,0,0,1,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0}
        };
        solve(arr);
    }

    static int dfs(int x,int y,int[][] arr) {
        arr[x][y] = 0;
        int sum = 1;
        for(int dx = -1; dx <= 1; dx++) {
            for(int dy = -1; dy <= 1; dy++) {
                int nx = x + dx,ny = y + dy;
                if(0 <= nx && nx < M && 0 <= ny && ny < N && arr[nx][ny] == 1) {
                    sum += dfs(nx,ny,arr);
                }
            }
        }

        return sum;
    }

    static void solve(int[][] arr) {
        int result = 0;
        int maxSum = -1;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {

                if(arr[i][j] == 1) {
                    int sum = dfs(i,j,arr);
                    if(sum > maxSum) maxSum = sum;
                    result++;
                }
            }
        }

        System.out.print(result + "," + maxSum);
    }
}
