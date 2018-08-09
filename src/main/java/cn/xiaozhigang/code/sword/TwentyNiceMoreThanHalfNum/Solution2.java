package cn.xiaozhigang.code.sword.TwentyNiceMoreThanHalfNum;

public class Solution2 {
    public static void main(String[] args) {
        int [] test = {1,1,1,1,2,2,3,5,1};
        int [] test1 = {2,3,2,2,2,5,4,2,3,3,2,2,2,1};
        int [] test2 = {1,2,3,2,2,2,5,4,2};
        Solution2 so = new Solution2();
        System.out.println(so.MoreThanHalfNum_Solution(test));
        System.out.println(so.MoreThanHalfNum_Solution(test1));
        System.out.println(so.MoreThanHalfNum_Solution(test2));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) return 0;
        int currentNum = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] == currentNum) {
                count++;
            } else if(count > 0) {
                count--;
            } else {
                count = 0;
                currentNum = array[i];
            }
        }
        if(count > 0)
            return checkMoreThanHalfNum(array,currentNum)?currentNum:0;
        else
            return 0;
    }

    private boolean checkMoreThanHalfNum(int[] array,int target) {
        int count = 0;
        for (int i : array) {
            if(i == target) count++;
        }
        return count > (array.length / 2);
    }
}
