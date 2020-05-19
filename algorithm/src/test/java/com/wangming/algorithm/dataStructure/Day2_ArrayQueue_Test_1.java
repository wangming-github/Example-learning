package com.wangming.algorithm.dataStructure;

import java.util.Scanner;


/**
 * 描述：使用数组模拟队列 （队列是有序列表 先入先出）
 * 缺点：
 * 1) 目前数组使用一次就不能用， 没有达到复用的效果
 * 2) 将这个数组使用算法，改进成一个环形的队列 取模:%
 *
 * @auther MaiZi
 * @date 2019-07-24 11:43
 */
public class Day2_ArrayQueue_Test_1 {
    //测试 数组模拟的队列
    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(3);

        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("********************************************************************************************************");
            System.out.println("*  s(show):显示队列   e(exit):退出程序    a(add):添加数据到队列    g(get):从队列取出数据    h(head):显示队列头     *");
            System.out.println("********************************************************************************************************");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int value = arrayQueue.getQueue();
                        System.out.printf("取出的数:%d\n", value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int frontData = arrayQueue.headQueue();
                        System.out.printf("队列头的数:%d\n", frontData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出!");
    }

}

//使用数组模拟队列
//-编写ArrayQueue类
class ArrayQueue {

    //front 会随着数据输出而改变，rear 则是随着数据输入而改变
    //1) 将尾指针往后移: rear+1 , 当 front == rear 【空】
    //2) 若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear 所指的数组元素中，否则无法存入数据。rear == maxSize - 1[队列满]

    private int maxSize;//队列最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] queue; //模拟队列


    //创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = -1; // 指向队列头部，分析出 front 是指向队列头的前一个位置.
        rear = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    //判断队列是否满了
    public boolean isFull() {
        return rear == maxSize - 1;//数组下标从0开始 当最大容量为3时存放满了，下标为maxSize - 1；
    }

    //判断队列是否为空
    public boolean isEmptyl() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满了！");
            return;
        }
        rear++;//rear 后移
        queue[rear] = n;
    }

    //获取数据
    public int getQueue() {

        if (isEmptyl()) {
            throw new RuntimeException("队列为空！");
        }

        front++;//front 后移
        return queue[front];
    }

    //展示数据
    public void showQueue() {

        if (isEmptyl()) {
            System.out.println("队列为空!");
            return;
        }

        for (int i = 0; i < queue.length; i++) {
            System.out.printf("queue[%d]=%d\n", i, queue[i]);
        }
    }

    //展示队列头是多少，不是取出数据
    public int headQueue() {

        if (isEmptyl()) {
            throw new RuntimeException("队列为空！");
        }
        //front 是指向队列头的前一个位置.
        return queue[front + 1];
    }

}