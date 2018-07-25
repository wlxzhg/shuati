package cn.xiaozhigang.code.sword.reOrderArray;

public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0)
            return;
        int i = 0,j = 0,tmp,len = array.length;
        while (i < len && j < len) {
            while (array[i] % 2 == 1) i++;
            while (array[j] % 2 == 0) j++;

            if(i < len && j < len) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        int[] array = {3,2,1,4,7,8};
        so.reOrderArray(array);
        for(int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();

        int[] array1 = {1,1,1,1,1,1};
        so.reOrderArray(array1);
        for(int i : array1) {
            System.out.print(i + "\t");
        }
        System.out.println();

        int[] array2 = {2,2,2,2,2,2};
        so.reOrderArray(array2);
        for(int i : array2) {
            System.out.print(i + "\t");
        }
        System.out.println();

        int[] array3 = {2,4,6,7,1,1,1,3};
        so.reOrderArray(array3);
        for(int i : array3) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
