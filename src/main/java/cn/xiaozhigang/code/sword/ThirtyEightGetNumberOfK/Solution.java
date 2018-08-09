package cn.xiaozhigang.code.sword.ThirtyEightGetNumberOfK;

public class Solution {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.GetNumberOfK(new int[] {2,5},2));
    }


    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0 || (k < array[0] || k > array[array.length - 1]))
            return 0;

        int i = 0,j = array.length - 1;
        int mid = 0,left = -1,right = -1;
        while (i <= j) {
            mid = i + (j - i) / 2;

            if(array[mid] == k) {
                if(mid == 0 || array[mid - 1] != k) {
                    left = mid;
                    break;
                } else {
                    j = mid - 1;
                }
            } else if(array[mid] < k)
                i = mid + 1;
            else
                j = mid - 1;
        }
        if(left == -1) return 0;
        i = 0;
        j = array.length - 1;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if(array[mid] == k) {
                if(mid == array.length - 1 || array[mid + 1] != k) {
                    right = mid;
                    break;
                } else {
                    i = mid + 1;
                }
            } else if(array[mid] < k) {
                i = mid + 1;
            } else
                j = mid - 1;
        }

        return (right - left) + 1;
    }
}
