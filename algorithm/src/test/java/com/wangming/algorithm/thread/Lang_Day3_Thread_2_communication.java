package com.wangming.algorithm.thread;

/**
 * 功能描述:线程通信 下面三个方法都必须在同步代码块OR同步方法中
 * wait(); 一旦一个线程执行到wait()，它就释放当前的锁。让其他线程进来。
 * notify(); 唤醒一个wait()的线程。
 * notifyAll();唤醒多少wait()的线程。
 * <p>
 * QA：创建两个线程 交替输出1-100
 */
class PrintNum implements Runnable {

    private int num = 1;

    @Override
    public void run() {
        while (true) {

            //方法1：代码块同步线程
            //synchronized (this) {
            //    //唤醒
            //    notify();
            //
            //    if (num <= 100) {
            //
            //        //使得异常更加明显
            //        try {
            //            Thread.sleep(10);
            //        } catch (InterruptedException e) {
            //            e.printStackTrace();
            //        }
            //
            //        System.out.println(Thread.currentThread().getName() + ":" + num);
            //        num++;
            //    } else {
            //        break;
            //    }
            //
            //    //1.当前线程等待，释放锁。等其他线程来执行....
            //    //只执行两次
            //    try {
            //        wait();
            //    } catch (InterruptedException e) {
            //        e.printStackTrace();
            //    }
            //}


            //方法2：方法同步线程
            print();

        }
    }


    public synchronized void print() {
        if (num <= 100) {

            notify();

            //使得异常更加明显
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":" + num);
            num++;

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class Lang_Day3_Thread_2_communication {


    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();

        Thread thread1 = new Thread(printNum);
        thread1.setName("TONY");
        thread1.start();

        Thread thread2 = new Thread(printNum);
        thread2.setName("张三");
        thread2.start();

    }

}
