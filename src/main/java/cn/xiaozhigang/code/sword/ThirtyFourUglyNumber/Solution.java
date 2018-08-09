package cn.xiaozhigang.code.sword.ThirtyFourUglyNumber;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
//        System.out.println(so.GetUglyNumber_Solution(1));
//        System.out.println(so.GetUglyNumber_Solution(2));
//        System.out.println(so.GetUglyNumber_Solution(3));
//        System.out.println(so.GetUglyNumber_Solution(20));
        System.out.println(so.GetUglyNumber_Solution(5));

    }

    public int GetUglyNumber_Solution(int index) {
        if(index < 1) return 0;
        int[] numbers = new int[index + 3];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        int t2 = 2,t3 = 1,t5 = 0,min;
        for(int i = 4; i < index; i++) {
            min = minInThree(numbers, t2, t3, t5);

            numbers[i] = min;

            while (numbers[t2] * 2 <= numbers[i])
                t2++;
            while (numbers[t3] * 3 <= numbers[i])
                t3++;
            while (numbers[t5] * 5 <= numbers[i])
                t5++;
        }
        System.out.println(Arrays.toString(numbers));
        return numbers[index - 1];
    }

    private int minInThree(int[] numbers,int t2,int t3,int t5) {
        int min = (numbers[t2] * 2 <= numbers[t3] * 3)?numbers[t2] * 2:numbers[t3] * 3;
        min = (min <= numbers[t5] * 5)?min:numbers[t5] * 5;
        return min;
    }
}
