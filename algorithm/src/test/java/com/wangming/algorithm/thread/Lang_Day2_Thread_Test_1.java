package com.wangming.algorithm.thread;


/*
 * 功能描述:
 * Q: 银行有一个账户，有两个储户分别向这个账户存3000元，每次存1000元，存3次，每次存钱打印余额。
 *
 * A: 是否涉及到多线程? 有 （两种方法处理）
 * A: 是否有共享数据？（线程安全问题）
 * A: 线程同步解决共享数据安全
 */


//储户
class Depositor implements Runnable {

    double totalAmount = 0;

    @Override
    public void run() {
        deposit();
    }

    //存款
    public synchronized void deposit() {

        int i = 1;
        while (i <= 30) {

            //使用线程通信 交替存钱
            notify();

            totalAmount += 1000;
            System.out.println(Thread.currentThread().getName() + "第" + i + "次存款，总余额:" + totalAmount);
            i++;

            //使用线程通信 交替存钱
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}


public class Lang_Day2_Thread_Test_1 {

    public static void main(String[] args) {
        Depositor depositor = new Depositor();

        Thread thread1 = new Thread(depositor);
        thread1.setName("储户A ");
        thread1.start();

        Thread thread2 = new Thread(depositor);
        thread2.setName("储户B ");
        thread2.start();


    }

}
