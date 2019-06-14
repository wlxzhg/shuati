package cn.xiaozhigang.code.Leetcode.nowcoder.JumpGame;

public class Solution {
    /**
     * 题目：给定一个非负整数数组，你最初位于数组的第一个位置。
     *      数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *      判断你是否能够到达最后一个位置
     * 思路：贪心。记录当前已知的能跳到的最大位置，此位置大于
     *      等于最后一个位置时返回true。遍历此位置之前的元素，
     *      若遍历结束也到不了最后的位置返回false。
     * */
    public boolean canJump(int[] A) {
        if(A == null)
            return false;

        int target = A.length - 1;
        int index = 0,max = 0;
        while(index <= max) {
            if(max < index + A[index]) {
                max = index + A[index];
            }
            index++;
            if(max >= target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        boolean res = so.canJump(new int[] {3,2,1,0,4});
        System.out.println(res);
    }
}
