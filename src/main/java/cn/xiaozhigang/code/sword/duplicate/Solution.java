package cn.xiaozhigang.code.sword.duplicate;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        int [] result = new int[1];
        System.out.println(so.duplicate2(new int[] {1,0},2,result));
        System.out.println(result[0]);
    }

    /**
     * O(N*logN)
     * */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 1) return false;
        Arrays.sort(numbers);
        for(int i = 1; i < length; i++) {
            if(numbers[i] == numbers[i - 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * O(N)
     * */
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 1) return false;

        for(int i = 0; i < length; i++) {
            int index = numbers[i];
            if(index >= length) {
                index -= length;
            }
            if(numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        System.out.println(Arrays.toString(numbers));

        return false;
    }

    private void swap(int [] numbers,int i,int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
