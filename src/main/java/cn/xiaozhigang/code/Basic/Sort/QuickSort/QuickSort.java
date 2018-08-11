package cn.xiaozhigang.code.Basic.Sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] test = {4,3,10,1,100,-1};
        int[] test2 = {10,9,8,7,6};
        int[] test3 = {1,2,3,4,5};
        quickSort(test);
        quickSort(test2);
        quickSort(test3);

        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
    }

    public static void quickSort(int[] arr) {
        if(arr == null || arr.length == 0) return;
        quickSort(arr,0,arr.length - 1);
    }

    private static void quickSort(int [] arr,int i,int j) {
        int index = Partition(arr,i,j);
        if(index > i) quickSort(arr,i,index - 1);
        if(index < j) quickSort(arr,index + 1,j);
    }

    public static int Partition(int[] arr,int start,int end) {
        int index = start;
        int small = index - 1;
        swap(arr,index,end);
        for(index = start; index < end; index++) {
            if(arr[index] < arr[end]) {
                small++;
                if(small != index)
                    swap(arr,small,index);
            }
        }
        small++;
        swap(arr,small,end);
        return small;
    }

    private static void swap(int [] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}