package cn.xiaozhigang.code.Basic.ConcurrencyDemo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerDemo {
    static int ThreadCount = 2;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(ThreadCount);
        final Exchanger<String> exchanger = new Exchanger<String>();

        threadPool.execute(new Runnable() {
            public void run() {
                try {
                    String b = exchanger.exchange("hello,anyone");
                    System.out.println("thread1 reviced :" + b);
                } catch (Exception e) {

                }
            }
        });

        threadPool.execute(new Runnable() {
            public void run() {
                try {
                    String a = exchanger.exchange("hello,anybody");
                    System.out.println("thread2 reviced :" + a);
                } catch (Exception e) {

                }
            }
        });

    }
}
