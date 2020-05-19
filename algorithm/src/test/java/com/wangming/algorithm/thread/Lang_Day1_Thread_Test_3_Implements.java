package com.wangming.algorithm.thread;


//窗口
class Window_New implements Runnable {

    //公用一个属性
    int ticket = 100;

    public void run() {
        while (true) {
            if (ticket > 0) {

                System.out.println(Thread.currentThread().getName() + "售出:" + ticket--);

            } else {
                break;
            }
        }
    }
}

//此程序会出现线程安全问题

//使用 implements Runnable 实现 模拟车站窗口售票 三个窗口 100张票
//使用 implements Runnable 实现 共创建一个对象
public class Lang_Day1_Thread_Test_3_Implements {

    public static void main(String[] args) {

        //使用 implements Runnable 实现 共创建一个对象
        Window_New target = new Window_New();

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


}
