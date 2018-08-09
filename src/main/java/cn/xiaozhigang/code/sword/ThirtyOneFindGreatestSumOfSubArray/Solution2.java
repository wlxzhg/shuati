package cn.xiaozhigang.code.sword.ThirtyOneFindGreatestSumOfSubArray;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 so = new Solution2();

        System.out.println(so.FindGreatestSumOfSubArray(new int[] {1,-2,3,10,-4,7,2,-5}));
        System.out.println(so.FindGreatestSumOfSubArray(new int[] {6,-3,-2,7,-15,1,2,2}));
        System.out.println(so.FindGreatestSumOfSubArray(new int[] {-6,-3,-2,-7,-15,-1,-2,-20}));
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0)
            return 0;
        int first = array[0];
        int next = 0;
        int result = array[0];
        for(int i = 1; i < array.length; i++) {
            if(first < 0)
                next = array[i];
            else{
                next = first + array[i];
            }
            first = next;
            if (result < next) result = next;
        }
        return result;
    }
}
