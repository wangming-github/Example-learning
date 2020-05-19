package com.wangming.algorithm.thread;


//实现窗口
class Window_Security_2 implements Runnable {

    int ticket = 100;//共享数据

    public void run() {
        while (true) {
            show();
        }
    }

    //A3.2.同步方法
    private synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(10); //线程安全问题,等待100毫秒。会出现错误:一张票重复售出
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售出:" + ticket--);
        }
    }
}

//继承窗口
class Window_Security_3 extends Thread {
    static int ticket = 100; //共用一个属性

    public void run() {
        while (true) {
            show();
        }
    }

    //synchronized 不能用来声明 extends Thread
    private synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);//线程安全问题,等待100毫秒。会出现错误:一张票重复售出
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售出:" + ticket--);
        }
    }
}

/**
 * A3.2.同步方法
 * 将操作共享数据的方法声明为synchronized能够保证当其中一个线程执行此方法时，其他线程在外等待，直到当前线程执行完此方法。
 * 同步方法的锁 当前对象
 * <p>
 * A3.3.锁
 */
public class Lang_Day1_Thread_Test_5_Synchronized {


    public static void main(String[] args) {

        implementsSecurity();
        //extendsSecurity();  //锁仍然是当前对象 但是this声明了三个对象每个线程仍然用自己的锁 so 错误
    }

    private static void implementsSecurity() {
        //使用 implements Runnable 实现 共创建一个对象
        Window_Security_2 target = new Window_Security_2();

        //创建一个线程
        //多线程启动 必须调用 start()方法 想办法让Runnable和Thread产生关系
        Thread window1 = new Thread(target);
        //启动线程:thread生成时执行构造器中形参的对象的run方法
        window1.setName("窗口1");
        window1.start();

        //再次创建一个线程直接创建Thread对象
        Thread window2 = new Thread(target);
        window2.setName("窗口2");
        window2.start();

        //再次创建一个线程直接创建Thread对象
        Thread window3 = new Thread(target);
        window3.setName("窗口3");
        window3.start();

    }


    private static void extendsSecurity() {

        // 三个对象独立 必须公用一个static 属性
        Window_Security_3 window_security_1 = new Window_Security_3();
        Window_Security_3 window_security_2 = new Window_Security_3();
        Window_Security_3 window_security_3 = new Window_Security_3();

        window_security_1.setName("窗口1");
        window_security_2.setName("窗口2");
        window_security_3.setName("窗口3");

        window_security_1.start();
        window_security_2.start();
        window_security_3.start();
    }


}
