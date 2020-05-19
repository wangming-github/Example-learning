package com.wangming.algorithm.thread;

/**
 * @version V1.0
 * @auther MaiZi
 * @date 2020-04-07 22:25
 */
public class Test_1 {

    private static volatile boolean init = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread("线程A") {
            public void run() {
                System.out.println(theardName() + " wait....");
                while (!init) {
                }
                System.out.println(theardName() + " success!");
            }

        }.start();

        Thread.sleep(2000);

        new Thread("线程B") {
            public void run() {
                System.out.println(theardName() + " change....");
                init = true;
                System.out.println(theardName() + " change end!");
            }
        }.start();
    }

    private static String theardName() {
        return Thread.currentThread().getName();
    }
}

