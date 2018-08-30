package cn.xiaozhigang.code.sword.MinNum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(minNumberOfArray(arr));
    }

    public static int minNumberOfArray(int[] array) {
        if(array == null || array.length == 0)
            throw new IllegalArgumentException();
        if(array.length == 1) return array[0];

        if(array[0] < array[array.length - 1]) return array[0];

        int low = 0,high = array.length - 1,mid;
        while (high - low > 1) {
            mid = low + (high - low) / 2;
            if(array[mid] == array[low] && array[mid] == array[high]) {
                return minNumberOfArrayInOrder(array);
            }
            if(array[mid] >= array[low])
                low = mid + 1;
            else if(array[mid] <= array[high])
                high = mid;

        }
        return Math.min(array[high],array[low]);
    }

    private static int minNumberOfArrayInOrder(int [] arr) {
        int min = arr[0];
        for (int i : arr) {
            if(i < min) min = i;
        }
        return min;
    }

}
