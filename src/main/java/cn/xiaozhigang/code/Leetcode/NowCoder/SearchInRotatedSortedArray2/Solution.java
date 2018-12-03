package cn.xiaozhigang.code.Leetcode.NowCoder.SearchInRotatedSortedArray2;

public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null)
            return false;

        int i = 0, j = A.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            System.out.println("i = " + i + ", j = " + j + ", m = " + m);
            if(target == A[m])
                return true;
            else if(A[i] < A[j]) {
                if(target < A[m])
                    j = m - 1;
                else
                    i = m + 1;
            } else if(A[i] == A[j]) {
                for(int k = i; k <= j; k++) {
                    if(A[k] == target)
                        return true;
                }
                return false;
            } else if(A[i] <= A[m]) {
                if(target >= A[i] && target < A[m])
                    j = m - 1;
                else
                    i = m + 1;
            } else if(A[m] <= A[j]) {
                if(target > A[m] && target <= A[j])
                    i = m + 1;
                else
                    j = m - 1;
            } else
                return false;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        int[] arr = {2,3,1,1,1};
        System.out.println(so.search(arr,3));
        // System.out.println(so.search(arr,3));
        // for(int i = 1; i < 9; i++) {
        // 	System.out.println(so.search(arr,i));
        // }

        // int[] a = {5,1,3};
        // System.out.println(so.search(a,1));
    }
}
