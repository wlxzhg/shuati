package cn.xiaozhigang.code.Basic.ConcurrencyDemo;

public class ThreadLocalDemo {
    static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    public static void main(String[] args) throws Exception{
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(threadLocal.get());
            }
        });

        thread1.start();
        thread1.join();
        System.out.println(threadLocal.get());
    }
}
