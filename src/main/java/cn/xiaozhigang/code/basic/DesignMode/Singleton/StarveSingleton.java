package cn.xiaozhigang.code.basic.DesignMode.Singleton;

public class StarveSingleton {
    private static final StarveSingleton instance = new StarveSingleton();

    public static StarveSingleton getInstance() {
        return instance;
    }
}
