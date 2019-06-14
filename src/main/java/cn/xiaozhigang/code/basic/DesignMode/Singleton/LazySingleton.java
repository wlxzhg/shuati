package cn.xiaozhigang.code.basic.DesignMode.Singleton;

public class LazySingleton {
    private static class Holder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }

    private LazySingleton() { }

    public static LazySingleton getInstance() {
        return Holder.INSTANCE;
    }
}
