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

//方法2： 继承Thread类的匿名类对象
public class Lang_Day1_Thread_4 {

    public static void main(String[] args) {


        //方法2： 继承Thread类的匿名类对象

        new Thread() {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();


        //方法2：继承Thread类的匿名类对象
        new Thread() {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }

}