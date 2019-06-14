package cn.xiaozhigang.code.Leetcode.nowcoder.SortColors;

public class Solution {
    /**
     * 题目：数组中只有0,1,2三种数。给数组从小打大排序。
     * 思路：需要两趟遍历的算法：一次遍历记录0,1,2分别的个数。
     *       第二次给数组赋值。
     *       只需一次遍历的算法：两个指针i0,i2记录0元素下一个
     *       应放在的位置和2元素下一个的位置。i遍历数组。若A[i]
     *       ==0则和A[i0]交换，若A[i]==2则和A[i2]交换
     * */
    public void sortColors(int[] A) {
        int count0 = 0,count1 = 0,count2 = 0;
        for(int i : A) {
            if(i == 0)
                count0++;
            else if(i == 1)
                count1++;
            else
                count2++;
        }
        int index = 0;
        for(int i = 0; i < count0; i++)
            A[index++] = 0;
        for(int i = 0; i < count1; i++)
            A[index++] = 1;
        for(int i = 0; i < count2; i++)
            A[index++] = 2;
        return;
    }

    public void sortColors2(int[] A) {
        if(A == null || A.length <= 1)
            return;
        int len = A.length - 1;
        int index0 = 0,index2 = len;

        int index = 0;
        while(index <= index2) {
            if(A[index] == 2) {
                A[index] = A[index2];
                A[index2--] = 2;
            } else if(A[index] == 0 && index != index0) {
                A[index] = A[index0];
                A[index0++] = 0;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] A = {2,0,1};
        so.sortColors2(A);
        for(int i : A) {
            System.out.println(i);
        }
    }
}
