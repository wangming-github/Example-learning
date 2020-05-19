package com.wangming.algorithm.thread;


import org.junit.Test;

/**
 * 模拟车站窗口售票 三个窗口 100张票
 */

//窗口
class Window extends Thread {

    //公用一个属性
    static int ticket = 100;

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

//使用 extends Thread  实现 模拟车站窗口售票 三个窗口 100张票
//使用 extends Thread  实现 需要创建三个对象 数据共享 需要设置静态共享
public class Lang_Day1_Thread_Test_1_Extends {

    public static void main(String[] args) {

        // 三个对象独立 必须公用一个static 属性
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }


}
