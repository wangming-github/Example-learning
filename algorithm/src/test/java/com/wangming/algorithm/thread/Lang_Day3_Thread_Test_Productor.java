package com.wangming.algorithm.thread;

/**
 * 经典例题:生产者/消费者
 * ● 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20)，
 * 如果生产者试图生产更多的产品，店员会叫生产者停-一下，
 * 如果店中有空位放产品了再通知生产者继续生产:
 * 如果店中没有产品了,店员会告诉消费者等一下，
 * 如果店中有产品了再通知消费者来取走产品。
 * <p>
 * <p>
 * ●这里可能出现两个问题:
 * ➢ 生产者比消费者快时，消费者会漏掉--些数据没有取
 * 到。
 * ➢ 消费者比生产者快时，消费者会取相同的数据。
 */

/**
 * 功能分析:
 * 1.是否涉及到多线程问题:是的
 * 2.是否有多线程:是的(生产者 消费者)
 * 3.是否有共享数据:是的(店员,产品数量)
 * 4.是否涉到线程通信:是的(生产者，消费者生产到一定数量 停)
 */

class Clerk {
    int product;

    //添加产品
    public synchronized void addProductor() {

        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            product++;
            System.out.println(Thread.currentThread().getName() + "生产了第 " + product + " 个产品");
            notifyAll();
        }

    }

    //消费产品
    public synchronized void Custome() {

        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "消费了第 " + product + " 个产品");
            product--;
            notifyAll();
        }
    }
}

//生产者
class Productor implements Runnable {

    Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("生产者开始生产产品");

        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.addProductor();
        }
    }
}


//消费者
class Customers implements Runnable {
    Clerk clerk;

    public Customers(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("消费者开始消费产品");
        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.Custome();
        }
    }
}

public class Lang_Day3_Thread_Test_Productor {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Customers customers = new Customers(clerk);

        Thread thread1 = new Thread(productor);
        thread1.setName("生产者1 ");

        Thread thread2 = new Thread(customers);
        thread2.setName("消费者1 ");

        Thread thread3 = new Thread(productor);
        thread3.setName("生产者2 ");

        Thread thread4 = new Thread(customers);
        thread4.setName("消费者2 ");

        Thread thread5 = new Thread(customers);
        thread5.setName("消费者3 ");

        thread1.start();
        thread2.start();
        thread3.start();
        //thread4.start();
        //thread5.start();
    }
}
