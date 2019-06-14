package cn.xiaozhigang.code.Leetcode.nowcoder.SearchInsertPosition;

public class Solution {
    /**
     * 题目：在排序数组中查找指定数字。
     *      若找不到则返回其应该插入的位置
     * 思路：二分查找。关键注意找不到时返回值怎么来的。
     * */
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0)
            return 0;

        int i = 0,j = A.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if(A[mid] == target)
                return mid;
            else if(A[mid] > target)
                j = mid - 1;
            else
                i = mid + 1;
        }

        return i;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        int res = so.searchInsert(new int[] {1,3,5,6},5);
        System.out.println(res);

        res = so.searchInsert(new int[] {1,3,5,6},2);
        System.out.println(res);

        res = so.searchInsert(new int[] {1,3,5,6},7);
        System.out.println(res);

        res = so.searchInsert(new int[] {1,3,5,6},0);
        System.out.println(res);
    }
}
