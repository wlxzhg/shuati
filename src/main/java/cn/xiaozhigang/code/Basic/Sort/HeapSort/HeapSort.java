package cn.xiaozhigang.code.Basic.Sort.HeapSort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] test = {4,3,10,1,100,-1};
        int[] test2 = {10,9,8,7,6};
        int[] test3 = {4,3,1,20,18};

        heapSort(test);
        heapSort(test2);
        heapSort(test3);

        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
    }

    private static int leftChild(int i) {
        return i * 2 + 1;
    }


    private static void percDown(int[] arr,int i,int n) {
        int child;
        int tmp;
        for (tmp = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++;
            }

            if (tmp < arr[child]) {
                arr[i] = arr[child];
            } else {
                break;
            }
        }

        arr[i] = tmp;
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length <= 1)
            return;

        for(int i = arr.length / 2; i >= 0; i--) {
            percDown(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr,0,i);
            percDown(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
