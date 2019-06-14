package cn.xiaozhigang.code.basic.DesignMode.Singleton;

public class LazySingletonSafe3 {
    private LazySingletonSafe3() {}

    private static LazySingletonSafe3 single = null;

    public static LazySingletonSafe3 getInstance() {
        if(single == null) {
            synchronized (LazySingletonSafe3.class) {
                if(single == null) {
                    single = new LazySingletonSafe3();
                }
            }
        }
        return single;
    }
}
