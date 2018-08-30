package cn.xiaozhigang.code.Basic.DesignMode.Singleton;

public class LazySingletonSafe2 {
    private LazySingletonSafe2() {}

    private static class Holder {
        private static final LazySingletonSafe2 instance = new LazySingletonSafe2();
    }

    public static LazySingletonSafe2 getInstance() {
        return Holder.instance;
    }

}
