package cn.xiaozhigang.code.sword.ThirtyOneFindGreatestSumOfSubArray;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();

        System.out.println(so.FindGreatestSumOfSubArray(new int[] {1,-2,3,10,-4,7,2,-5}));
        System.out.println(so.FindGreatestSumOfSubArray(new int[] {6,-3,-2,7,-15,1,2,2}));
        System.out.println(so.FindGreatestSumOfSubArray(new int[] {-6,-3,-2,-7,-15,-1,-2,2}));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return 0;

        int greatestSum = 0;
        int currentSum = 0;
        for(int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if(currentSum < 0)
                currentSum = 0;
            if(currentSum > greatestSum)
                greatestSum = currentSum;
        }

        return (greatestSum == 0)?findMax(array):greatestSum;
    }

    public int findMax(int[] array) {
        int max = array[0];
        for(int i : array) {
            if(i > max) max = i;
        }
        return max;
    }
}
