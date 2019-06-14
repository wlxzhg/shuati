package cn.xiaozhigang.code.book.Algorithm.Chapter1;

public class BinarySearch {
    public static int rank(int key,int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(a[mid] > key)
                hi = mid - 1;
            else if(a[mid] < key)
                lo = mid + 1;
            else
                return mid;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
