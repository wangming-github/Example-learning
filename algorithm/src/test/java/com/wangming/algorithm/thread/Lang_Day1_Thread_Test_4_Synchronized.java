package com.wangming.algorithm.thread;


//实现窗口
class Window_Security implements Runnable {

    //共享数据
    int ticket = 100;
    Object object = new Object();//同步监视器对象

    public void run() {
        //FIXME 同步监视器对象 放在局部变量的位置 不会起作用
        //Object object = new Object();
        while (true) {
            synchronized (object) {
                //synchronized (this) { //this表示当前对象（即为 target ，多个线程公用了一个target），也可以充当同步监视器。
                if (ticket > 0) {

                    try {
                        Thread.sleep(10); //线程安全问题,等待100毫秒。会出现错误:一张票重复售出
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "售出:" + ticket--);
                } else {
                    break;
                }

            }
        }
    }
}

//继承窗口
class Window_Security_1 extends Thread {


    static int ticket = 100; //共用一个属性
    static Object object = new Object();//static声明共用一个同步监视器对象

    public void run() {
        while (true) {
            synchronized (this) { //this 指的是 window_security_1 2 3 每个线程还是独立的锁
                //synchronized (object) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);//线程安全问题,等待100毫秒。会出现错误:一张票重复售出
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "售出:" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}

/**
 * Thread.sleep(100);后此程序会出现线程安全问题：一张票重复售出 错票
 * <p>
 * Q1.为什么会出现这个问题，WHY?
 * A1.一个线程操作共享数据过程中，没有执行完成。另一个线程参与进来，导致共享数据出现安全问题。
 * <p>
 * Q2.线程安全问题的解决?
 * A1.必须让一个线程操作共享数据完毕以后，其他线程才有机会参与共享数据的操作。
 * <p>
 * Q3.JAVA如何实现线程的同步机制？
 * <p>
 * A3.1.同步代码块
 * synchronized(同步监视器){
 * //需要被同步的代码块(即为操作共享数据的代码块)
 * }
 * 共享数据: 多个线程操作的同一个数据
 * 同步监视器: 由任何一个类的对象充当。作用:那个线程获取此监视器，就由该线程执行。注意：所有的线程公用同一个同步监视器。
 * synchronized (this) {} :implements「实现」是可以使用this来充当锁， extends时慎用 考虑this指代的是不是唯一对象。
 * <p>
 * A3.2.同步方法
 * A3.3.锁
 */

public class Lang_Day1_Thread_Test_4_Synchronized {


    public static void main(String[] args) {

        implementsSecurity();
        //extendsSecurity();
    }

    public static void implementsSecurity() {
        //使用 implements Runnable 实现 共创建一个对象
        Window_Security target = new Window_Security();

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
        Window_Security_1 window_security_1 = new Window_Security_1();
        Window_Security_1 window_security_2 = new Window_Security_1();
        Window_Security_1 window_security_3 = new Window_Security_1();

        window_security_1.setName("窗口1");
        window_security_2.setName("窗口2");
        window_security_3.setName("窗口3");

        window_security_1.start();
        window_security_2.start();
        window_security_3.start();
    }


}
