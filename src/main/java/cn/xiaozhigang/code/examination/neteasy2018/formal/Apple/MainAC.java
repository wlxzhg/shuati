package cn.xiaozhigang.code.examination.neteasy2018.formal.Apple;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 20180811 �������Ʊ���
 * AC����һ����
 * ��n��ƻ�����ӵ�һ�ѵĵ�һ����ʼ���򣬸���һ��������ڵڼ���
 * �ؼ������ֲ���
 * ��Ŀ��https://www.nowcoder.com/discuss/93285?type=2&order=3&pos=23&page=1
 * */
public class MainAC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] arr = new int[n];
        for (int i = 0;i<arr.length;i++){
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        int [] q = new int[m];
        for (int i=0;i<q.length;i++){
            q[i] = in.nextInt();
        }

        int[] tmp = new int[n];
        tmp[0] = arr[0];
        for(int i = 1; i < n; i++)
            tmp[i] = tmp[i-1] + arr[i];

        for (int i = 0;i<q.length;i++){
            int result = Arrays.binarySearch(tmp,q[i]);
            if(result < 0)
                result = -result;
            else
                result++;
            q[i] = result;

        }
        for (int i=0;i<q.length;i++){
            System.out.println(q[i]);
        }
    }
}
