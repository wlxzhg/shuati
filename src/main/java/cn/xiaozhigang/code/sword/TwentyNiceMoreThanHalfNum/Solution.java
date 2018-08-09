package cn.xiaozhigang.code.sword.TwentyNiceMoreThanHalfNum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int [] test = {1,1,1,1,2,2,3,5,1};
        int [] test1 = {2,3,2,2,2,5,4,2,3,3,2,2,2,1};
        Solution so = new Solution();
        System.out.println(so.MoreThanHalfNum_Solution(test));
        System.out.println(so.MoreThanHalfNum_Solution(test1));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) return 0;

        int start = 0;
        int end = array.length - 1;
        int mid = array.length / 2;
        int index = start;

        while (index != mid) {
            index = partition(array,start,end);
            if(index > mid) {
                end = index - 1;
            } else if(index < mid) {
                start = index + 1;
            }
            System.out.println("arr[" + index + "]=" + array[index] + " "+ Arrays.toString(array));
        }
        return checkIsMoreThanHalfNum(array,array[index])?array[index]:0;
    }

    private boolean checkIsMoreThanHalfNum(int[] array,int index) {
        int count = 0;
        for(int i : array) {
            if(i == index) count++;
        }
        return count > (array.length / 2);
    }

    private int partition(int[] arr,int start,int end) {
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

    private void swap(int [] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
