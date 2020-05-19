package com.wangming.algorithm.thread;


// 完成1-100之间自然数的输出，主线程的执行同样的操作
// 方法 1 继承的方式创建多线程
class Thread1 extends Thread {

    //NO1：重写Thread的run方法，方法内部实现此线程要完成的任务
    public void run() {
        for (int i = 1; i <= 10; i++) {
            //Thread-0
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}

public class Lang_Day1_Thread_1 {

    public static void main(String[] args) {

        //NO2：创建子类的对象
        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();

        //NO3：调用线程的start()，启动子线程，使得run方法开始执行。
        //一个线程只能够执行一次start()
        //不能通过thread1的run方法来启动线程
        thread1.start();
        thread2.start();

        for (int i = 1; i <= 10; i++) {
            //main
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}

