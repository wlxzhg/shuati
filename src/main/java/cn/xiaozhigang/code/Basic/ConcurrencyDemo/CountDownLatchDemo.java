package cn.xiaozhigang.code.Basic.ConcurrencyDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程1开始执行!");
                    Thread.sleep(3000);
                    System.out.println("线程1结束执行!");
                    c.countDown();
                } catch (InterruptedException e) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程2开始执行!");
                    Thread.sleep(5000);
                    System.out.println("线程2结束执行!");
                    c.countDown();
                } catch (InterruptedException e) {

                }
            }
        });
        t1.start();
        t2.start();
        try {
            System.out.println("开始等待线程1、2结束");
            c.await();
            System.out.println("线程1、2结束");
        } catch (InterruptedException e) {

        }
    }
}
