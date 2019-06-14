package cn.xiaozhigang.code.basic.DesignMode.Singleton;

public class LazySingletonSafe1 {
    private LazySingletonSafe1(){}

    private static LazySingletonSafe1 single = null;

    public static synchronized LazySingletonSafe1 getInstance() {
        if(single == null) {
            single = new LazySingletonSafe1();
        }
        return single;
    }
}

