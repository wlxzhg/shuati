package cn.xiaozhigang.code.sword.FortyFourIsContinuous;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.isContinuous(new int[] {1,2,3,0,0}));

    }

    public boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length < 5)
            return false;

        Arrays.sort(numbers);

        int zeroCount = 0;
        int i = 0;
        for(i = 0; i < 5; i++) {
            if(numbers[i] == 0)
                zeroCount++;
            else
                break;
        }

        int zeroNeed = 0;
        for(;i < 4; i++) {
            if(numbers[i + 1] == numbers[i]) {
                zeroNeed = 100;
                break;
            } else {
                zeroNeed += (numbers[i+1] - numbers[i] - 1);
            }
        }
        return (zeroCount >= zeroNeed);
    }
}
