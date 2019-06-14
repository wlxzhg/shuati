package cn.xiaozhigang.code.book.Algorithm.Chapter1;

public class Gcd {
    /*
    * 请两个数的最大公约数
    * 欧几里得算法：
    * 如果b是0，那么最大公约数是a，否则公约数是a处于b的余数和b的最大公约数
    * 经过测验，本算法对负数也适用
    * */
    public int gcd(int a,int b) {
        System.out.println("a == " + a + ", b = " + b);
        if(b == 0) return a;

        int r = a % b;
        return gcd(b,r);
    }

    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        System.out.println(gcd.gcd(-12,16));
        /**
         * 负数除法的计算：
         * 先算出a / b = c，这里按(abs)a / (abs)b计算
         * 再按a = b * c + r，即r = a - b * c算出余数r
         * */
        System.out.println(7 % -3);
        System.out.println(-7 % 3);
        System.out.println(7 / -3);
        System.out.println(-7 / 3);
    }

    /**
     * 练习1.1.24
     * */

    /**
     * 练习1.1.25
     * */
}
