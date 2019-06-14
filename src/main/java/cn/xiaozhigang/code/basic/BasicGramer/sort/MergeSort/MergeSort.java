package cn.xiaozhigang.code.basic.BasicGramer.sort.MergeSort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] test = {4,3,10,1,100,-1};
        int[] test2 = {10,9,8,7,6};
        int[] test3 = {4,3,1,20,18};
        mergeSort(test);
        mergeSort(test2);
        mergeSort(test3);

        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
    }

    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length <= 1) return;

        int[] tmp = new int[arr.length];

        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, mid + 1, right);
        }
    }

    private static void merge(int[] arr, int[] tmp, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1;
        int size = rightEnd - leftStart + 1;
        int tmpPos = leftStart;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            while (leftStart <= leftEnd && arr[leftStart] <= arr[rightStart]) {
                tmp[tmpPos++] = arr[leftStart++];
            }
            while (rightStart <= rightEnd && arr[rightStart] <= arr[leftStart]) {
                tmp[tmpPos++] = arr[rightStart++];
            }
        }
        while (leftStart <= leftEnd) {
            tmp[tmpPos++] = arr[leftStart++];
        }

        while (rightStart <= rightEnd) {
            tmp[tmpPos++] = arr[rightStart++];
        }

        for (int i = 0; i < size; i++) {
            arr[rightEnd - i] = tmp[rightEnd - i];
        }
    }
}
