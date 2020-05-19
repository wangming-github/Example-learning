package com.wangming.algorithm.thread;


/*
 * 功能描述:
 * Q: 银行有一个账户，有两个储户分别向这个账户存3000元，每次存1000元，存3次，每次存钱打印余额。
 *
 * A: 是否涉及到多线程? 有 （两种方法处理）
 * A: 是否有共享数据？（线程安全问题）
 * A: 线程同步解决共享数据安全
 */


//账户
class Account {

    double balance;


    public synchronized void deposit(double d) {

        //使用线程通信 交替存钱
        notify();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance += d;
        System.out.println(Thread.currentThread().getName() + ":" + balance);

        //使用线程通信 交替存钱
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

//储户
class Customer implements Runnable {

    Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }

}


public class Lang_Day2_Thread_Test_2 {

    public static void main(String[] args) {

        Customer customer = new Customer(new Account());

        Thread thread1 = new Thread(customer);
        thread1.setName("储户A ");
        thread1.start();

        Thread thread2 = new Thread(customer);
        thread2.setName("储户B ");
        thread2.start();


    }

}
