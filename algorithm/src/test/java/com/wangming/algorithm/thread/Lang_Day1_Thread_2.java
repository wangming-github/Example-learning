package com.wangming.algorithm.thread;


/**
 * thread1.start();//启动子线程，使得run方法开始执行。
 * Thread.currentThread();//静态方法 调用当前线程
 * <p>
 * getName() ;//调用当前线程名字
 * thread1.setName("子线程1");//设置当前线程名字
 * <p>
 * Thread.yield();//调用此方法的线程，释放当前CPU的执行权
 * thread1.join();//当前线程调用另一个线程B的Join方法，当执行到此方法当前线程立即停止，直到B线程执行完成，之后执行当前方法。
 * thread1.isAlive();//判断当前线程是否还存活
 * thread1.setPriority;//设置线程优先级
 */
class SubThread1 extends Thread {

    //NO1：重写Thread的run方法，方法内部实现此线程要完成的任务
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //try {
            //    Thread.sleep(100);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority() + ":" + i);
        }
    }

}

public class Lang_Day1_Thread_2 {

    public static void main(String[] args) {

        SubThread1 thread1 = new SubThread1();
        thread1.setName("子线程");
        //设置线程优先级:10 默认都是5 (10抢到的执行权的概率变大,并不知10执行完后5才执行)
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        Thread.currentThread().setName("======主线程======");
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority() + ":" + i);

            //调用此方法的线程，释放当前CPU的执行权
            //if (i == 40) {
            //    Thread.yield();
            //}

            //当前线程调用另一个线程B的Join方法，当执行到此方法当前线程立即停止，直到B线程执行完成，之后执行当前方法。
            //if (i == 30) {
            //    try {
            //        thread1.join();
            //    } catch (InterruptedException e) {
            //        e.printStackTrace();
            //    }
            //}

        }

        //判断当前线程是否还存活
        //if (thread1.isAlive()) {
        //    System.out.println(thread1.getName() + "还存活！");
        //} else {
        //    System.out.println(thread1.getName() + "死掉了！");
        //}

    }

}

