package com.wangming.algorithm.thread;

/**
 * 功能描述:死锁
 * <p>
 * 死锁问题：处理线程同步时容易出现
 * 不同线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程死锁。
 */
public class Lang_Day3_Thread_1_DeadLock {

    static StringBuffer stringBuffer0 = new StringBuffer();
    static StringBuffer stringBuffer1 = new StringBuffer();


    public static void main(String[] args) {


        new Thread() {
            public void run() {
                synchronized (stringBuffer0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    stringBuffer0.append("A");
                    synchronized (stringBuffer1) {
                        stringBuffer1.append("B");
                        System.out.println(stringBuffer0.toString());
                        System.out.println(stringBuffer1.toString());
                    }

                }
            }
        }.start();


        new Thread() {
            public void run() {
                synchronized (stringBuffer1) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    stringBuffer0.append("C");
                    synchronized (stringBuffer0) {
                        stringBuffer1.append("D");
                        System.out.println(stringBuffer0.toString());
                        System.out.println(stringBuffer1.toString());
                    }

                }
            }
        }.start();
    }

}
