package com.wangming.algorithm.dataStructure;

import java.util.Scanner;

/**
 * 描述：用取模的方式，将数组修改为环形的队列
 * 思路：
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-07-24 15:26
 */
public class Day2_ArrayQueue_Test_2 {
    //测试 数组模拟的队列
    public static void main(String[] args) {

        System.out.println("*************************");
        System.out.println("*  测试数组模拟环形队列     *");
        System.out.println("*************************");


        //设置4 其队列的有效数据为3 因为空了一个空间
        CircleArrayQueue arrayQueue = new CircleArrayQueue(3);

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

/**
 * 描述：用取模的方式，将数组修改为环形的队列
 * 思路：
 * 1.front 的含义做调整
 * ......>原先 front 指向是第一个元素的前一个位置（eg：-1，queue(front++) = 第一个元素），
 * ......>现在 front 指向是队列第一个元素的位置 （eg：queue(front) = 第一个元素）;
 * ......>front初始化为0;
 * 2.rear 的含义做调整
 * ......>原先 rear 指向的队列最后一个元素的位置     （eg：queue(rear) = 最后一个元素）
 * ......>现在 rear 指向的队列最后一个元素的后一个位置（eg：queue(rear--) = 最后一个元素）;因为希望空出一个空间作为约定，
 * ......>现在 rear 初始化为0;rear的位置为空出来的位置。
 * 3.当队列满的时候
 * ......>原先 rear=maxSize-1;
 * ......>现在 (rear+1)%maxSize=front;
 * 4.当队列空的时候
 * ......>原先 rear == front;
 * ......>现在 rear == front;
 * 4.当队列的有效数据
 * ......>现在 (rear + maxSize - front)%maxSize
 * <p>
 * <p>
 * 详解牵扯的算法
 * 第一种方法是设置一个标志量flag,当front==rear且flag=0时为空，当front==rear且flag=1时队列为满；
 * 第二种方法是我们修改条件，保留一个元素空间，也就是说，数组中还有一个空闲单元时，我们就认为这个队列已经满了。
 * 接下来我们重点讨论第二种方法，由于rear可能比front大，也可能是比front小，
 * 所以尽管他们只相差一个位置时候就是满的情况，但是也可能说是相差整整一圈。
 * 所以若队列最大尺寸为maxSize，那么队列满的条件就是:
 * (rear+1）%QueueSize==front
 * (这里取模“%”目的就是为了整合rear与front大小为一个问题）。
 * <p>
 * 比如图一所示，https://blog.csdn.net/return9/article/details/79672708
 * QueueSize=5,front=0,rear=4，根据公式（4+1）%5=0，所以此时队列满。
 * QueueSize=5,front=2,rear=1，根据公式（1+1）%2=0，所以此时队列满。
 * <p>
 * ........................................图一.......................................
 * .                                                                                .
 * .                                                                                .
 * .       front                   rear             rear   front                     .
 * .         ↓                       ↓                 ↓     ↓                      .
 * .      |     |     |     |     |     |     |     |     |     |     |     |       .
 * .      |  a1 |  a2 |  a3 |  a4 |     |     |  a6 |     |  a3 |  a4 |  a4 |       .
 * .      |_____|_____|_____|_____|_____|     |_____|_____|_____|_____|_____|       .
 * .  下标    0     1     2     3     4           0     1     2     3     4          .
 * .                                                                                .
 * .                                                                                .
 * ..................................................................................
 * .队列空的条件: rear == front
 * .队列满的条件: (rear+1）% QueueSize == front
 * .队列有效数据: (rear + QueueSize - front) % QueueSize
 *
 * @auther MaiZi
 * @date 2019-07-24 15:31
 */
class CircleArrayQueue {

    //front 会随着数据输出而改变，rear 则是随着数据输入而改变
    //1) 将尾指针往后移: rear+1 , 当 front == rear 【空】
    //2) 若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear 所指的数组元素中，否则无法存入数据。rear == maxSize - 1[队列满]

    private int maxSize;//队列最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] queue; //模拟队列


    //创建队列的构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmptyl() {
        return rear == front;
    }

    //添加数据=
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满了！");
            return;
        }
        //直接将数据加入
        queue[rear] = n;
        //将rear后移，必须考虑去模
        rear = (rear + 1) % maxSize;

    }

    //获取一个数据
    public int getQueue() {

        if (isEmptyl()) {
            throw new RuntimeException("队列为空！");
        }

        //这里需要分析出 front 指的是队列的第一个元素
        //1.先把 front对应的值保存在一个临时变量
        //2.将front 后移
        //3.将临时保存的变量返回
        int value = queue[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //展示队列数据
    public void showQueue() {

        if (isEmptyl()) {
            System.out.println("队列为空!");
            return;
        }

        //思路
        //从front开始遍历 遍历多少个元素
        //动脑筋
        for (int i = 0; i < front + size(); i++) {
            System.out.printf("queue[%d]=%d\n", i % maxSize, queue[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //展示队列头是多少，不是取出数据
    public int headQueue() {

        if (isEmptyl()) {
            throw new RuntimeException("队列为空！");
        }

        //front 是指向队列头的前一个位置.
        return queue[front];
    }

}
