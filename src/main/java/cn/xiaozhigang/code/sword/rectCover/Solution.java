package cn.xiaozhigang.code.sword.rectCover;

public class Solution {
    public int RectCover(int target) {
        if(target < 0) return -1;
        else if(target < 3) return  target;

        int first = 1,second = 2,tmp = 0;

        while(target >= 3) {
            tmp = first + second;
            first = second;
            second = tmp;
            target--;
        }
        return second;
    }

    public static void main(String [] args) {
        Solution so = new Solution();
        for(int i = 1; i < 20; i++) {
            System.out.println(so.RectCover(i));
        }
    }
}
