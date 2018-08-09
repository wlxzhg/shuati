package cn.xiaozhigang.code.sword.ThirtyThreePrintMinNumber;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        so.PrintMinNumber(new int[] {3,32,321});
        so.PrintMinNumber(new int[] {1,22,12});
        so.PrintMinNumber(new int[] {1,10,1});
    }


    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";

        quickSort(numbers);
        System.out.println(Arrays.toString(numbers));
        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(i);
        }
        return sb.toString();
    }

    private void quickSort(int[] numbers) {

        quickSort(numbers,0,numbers.length-1);
    }

    private void quickSort(int[] numbers,int start,int end) {
        if(end > start) {
            int part = partition(numbers,start,end);
            quickSort(numbers, start, part - 1);
            quickSort(numbers, part + 1, end);
        }
    }

    private int partition(int[] numbers,int i,int j) {
        int start = i,end = j;
        swap(numbers, start, end);
        start = i - 1;
        for(int m = i; m < end; m++) {
            if(compare(numbers[m],numbers[end]) < 0) {
                start++;
                swap(numbers,m,start);
            }
        }
        start++;
        swap(numbers,end,start);
        return start;
    }

    private void swap(int[] number,int i,int j) {
        int tmp = number[i];
        number[i] = number[j];
        number[j] = tmp;
    }
    private int compare(int a,int b) {
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);

        char[] arr1 = (str1 + str2).toCharArray();
        char[] arr2 = (str2 + str1).toCharArray();

        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i])
                return arr1[i] - arr2[i];
        }
        return 0;
    }
}
