package cn.xiaozhigang.code.Leetcode.NowCoder.SingleNumberII;

public class Solution {
    /**
     * 题目：数组中除了一个数出现了一次，其他数都出现了3次。
     *       找出唯一出现的这个数。
     * 思路：题目SingleNumber的解法本质上使用一个bit记录数字
     *       出现的次数，出现第一次时bit=x，第二次时bit=0。
     *       使用异或运算，满足交换律，问题解决。
     *       本题中数字要出现三次，使用一个bit不能解决问题了，
     *       应该使用两个bit，a和b。
     *       x第一次出现时，a = 0,b = x;
     *       x第二次出现时，a = x,b = 0;
     *       x第三次出现时，a = 0,b = 0;
     *       之后可以继续处理其它数字了
     *       最后返回b的值就是只出现一次的数。
     *       关键是找到一个运算使a,b满足上述要求。
     *       对于b，x的前两次出现可以用b ^ x来得到。
     *       关键是第三次0 ^ x (其它运算)= 0
     *       而第一次是：0 ^ x (其它运算)= x
     *       这两次时，a的值不同，一次为x一次为0
     *       可以看出其它运算为&~a
     * 参考：https://cloud.tencent.com/developer/article/1131945
     * */
    public int singleNumber(int[] A) {
        int b = 0,a = 0;
        for(int i : A) {
            b = b ^ i & ~a;
            a = a ^ i & ~b;
        }

        return b;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.singleNumber(new int[] {2,2,2,1,1,99,1}));
    }
}
