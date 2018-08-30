package cn.xiaozhigang.code.Basic.Sort.HeapSort;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        int[] arr = {4,3,1,9,8,0};
        (new HeapSortTest()).heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private void preDown(int[] arr,int i,int n) {
        int tmp;
        int child;
        for(tmp = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if(child < n -1 && arr[child] < arr[child + 1])
                child++;
            if(arr[child] > arr[i])
                arr[i] = arr[child];
            else
                break;
        }
        arr[i] = tmp;
    }

    public void heapSort(int[] arr) {
        if(arr == null || arr.length <= 1) return;

        int length = arr.length;
        for(int i = length / 2; i >= 0; i--)
            preDown(arr,i,length);

        for(int i = 0; i < length - 1;i++) {
            swap(arr,0,length-1-i);
            preDown(arr,0,length - i - 1);
        }
    }

    private void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
