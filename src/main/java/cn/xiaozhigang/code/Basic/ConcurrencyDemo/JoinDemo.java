package cn.xiaozhigang.code.Basic.ConcurrencyDemo;

public class JoinDemo {


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程1开始执行!");
                    Thread.sleep(3000);
                    System.out.println("线程1结束执行!");
                } catch (InterruptedException e) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("线程2开始执行!");
                    Thread.sleep(10000);
                    System.out.println("线程2结束执行!");
                } catch (InterruptedException e) {

                }
            }
        });
        t1.start();
        t2.start();

        try {
            System.out.println("before t1.join");
            t1.join();
            System.out.println("after t1 join");
            t2.join();
            System.out.println("after t2 join");
        } catch (InterruptedException e) {

        }
    }
}
