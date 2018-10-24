package cn.xiaozhigang.code.IEEEXtreme12.BarterSystem;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Goods {
    String name;
    String r;

    Goods(String n,String r) {
        this.name = n;
        this.r = r;
    }
}
public class Main {

    public static void main(String[] args) {
//        BigInteger a = new BigInteger("399297742");
//        BigInteger b = new BigInteger("598946612");
//
//        BigInteger c = a.multiply(b);
//        BigInteger mod = new BigInteger("998244353");
//        System.out.println(c.mod(mod));


        Scanner sc = new Scanner(System.in);
        Map<String, Goods> map = new HashMap<String, Goods>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] inputs = line.split(" ");
            map.put(inputs[0],new Goods(inputs[1],inputs[2]));
        }

        int q= sc.nextInt();
        for(int i = 0; i < q; i++) {
            String line = sc.nextLine();
            String[] inputs = line.split(" ");

        }
    }

    public static int func1(int e, int modValue) {
        int i;
        int over = e;
        for(i = 1; i < modValue;) {
            over = over % modValue;
            if (over == 1) {
                return i;
            } else {
                if (over + e <= modValue) {
                    do{
                        i++;
                        over += e;
                    } while (over + e <= modValue);
                } else {
                    i++;
                    over += e;
                }
            }
        }
        return 0;
    }
}
