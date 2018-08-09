package cn.xiaozhigang.code.sword.ThirthLeastNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();


        for(int i = 0; i <= 8; i++) {
            int[] test = new int[] {4,3,2,1,5,2,9};

            System.out.println(so.GetLeastNumbers_Solution(test,i).toString());

        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(input == null || input.length == 0 || k < 1 || k > input.length) return result;
        if(k == input.length) {
            for(int i : input) result.add(i);
            return result;
        }

        int start = 0,end = input.length - 1;
        int target = k;
        int index = start;

        while (index != target) {
            index = partition(input, start, end);
            if(index > target) {
                end = index - 1;
            } else if(index < target) {
                start = index + 1;
            }
        }

        for(int i = 0; i < k; i++) {
            result.add(input[i]);
        }

        return result;
    }

    public int partition(int[] input,int start,int end) {
        int index = start;
        int small = index - 1;
        swap(input, index, end);

        for(index = start; index < end; index++) {
            if(input[index] < input[end]) {
                small++;
                if(small != index) {
                    swap(input,small,index);
                }
            }
        }

        small++;
        swap(input, small, end);
        return small;
    }

    public void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
