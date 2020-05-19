package com.wangming.algorithm.thread;


/**
 * 使用实现过程创建多线程:
 * 1.创建一个实现了【Runnable】接口的类，进而实现run()方法
 * 2.里面为子线程执行的任务
 * 3.创建一个Runnable接口实现类的对象
 * 4.将此对象作为形参传递给 Thread 构造器中
 * 5.创建Thread对象，此对象即为一个线程
 * 6.调用Thread对象的start()方法启动线程，并执行run();
 * <p>
 * 继承[extend Thread]和实现[implements Runnable]两种多接口的创建方式都和多线程都和 Runnable 有关系
 * <p>
 * 多线程操作同一份资源，更适合使用实现的方式[implements Runnable]
 */

class PrintNum1 implements Runnable {


    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class Lang_Day1_Thread_Test_2_Implements {

    public static void main(String[] args) {

        PrintNum1 target = new PrintNum1();
        //创建一个线程
        //多线程启动 必须调用 start()方法 想办法让Runnable和Thread产生关系
        Thread thread1 = new Thread(target);
        //启动线程:thread生成时执行构造器中形参的对象的run方法
        thread1.start();

        //再次创建一个线程直接创建Thread对象
        Thread thread2 = new Thread(target);
        thread2.start();
    }


}
