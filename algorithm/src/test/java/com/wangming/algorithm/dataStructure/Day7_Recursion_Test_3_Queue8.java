package com.wangming.algorithm.dataStructure;

/**
 * 递归
 * 6.7.1
 * 八皇后问题介绍
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。
 * 该问题是国际西洋棋棋手马克斯·贝瑟尔于 1848 年提出:
 * 在 8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击，
 * 即:任意两个皇后都不能处于同一行、 同一列或同一斜线上，问有多少种摆法(92)。
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-08-21 17:49
 */
public class Day7_Recursion_Test_3_Queue8 {

    /*
     *定义MAX表示共有多少个皇后
     */
    int MAX = 8;
    static int count = 0;
    static int judgeCount = 0;

    /*
     *定义数组用于保存皇后位置的结果，比如arr[8]={0,4...}
     */
    int[] array = new int[MAX];

    /*
     * 打印皇后的位置
     */
    private void print() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    /**
     * 判断皇后是否会冲突,当我们放置第N个皇后时候，就去检测该皇后和前面已经摆放的皇后冲突
     * n :第N个皇后
     */
    private boolean judge(int n) {
        judgeCount++;
        //检测前面N-1个皇后
        for (int i = 0; i < n; i++) {
            //1.array[i] == array[n] 第N个皇后是否和前面N-1个皇后在同一列
            //2.Math.abs(n - i) == Math.abs(array[n] - array[i]) 第N个皇后是否和前面N-1个皇后在同一斜线
            //  eg:放置第2个皇后: n=1; 皇后放在第二列:n=1; |1-0|==|array[1]-array[0]|  ==> 1 =|1-0| ==> 1=1 ? true
            //  eg:放置第4个皇后: n=3; 皇后放在第四列:n=3; |3-0|==|array[3]-array[0]|  ==> 1 =|1-0| ==> 1=1
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }

        }
        return true;
    }

    /**
     * 描述：编写方法，放置第N个皇后
     * 特别注意：check每一次递归时，进入check都有for (int i = 0; i < MAX; i++),因此会有回溯
     */
    private void check(int n) {

        if (n == MAX) {//n=8,8个皇后已经放好
            print();
            count++;
            return;
        }

        for (int i = 0; i < MAX; i++) {
            //先把第N个皇后放到该行的第一个列
            array[n] = i;
            //判断放置第N个皇后到第i列时，是否冲突
            if (judge(n)) {  //不冲突
                //开始放置第N+1个皇后
                check(n + 1);
            }
            //如果冲突,就继续执行 array[n] = i; 即将皇后放在本行的下一列;
        }

    }


    public static void main(String[] args) {
        Day7_Recursion_Test_3_Queue8 queue8 = new Day7_Recursion_Test_3_Queue8();
        queue8.check(0);
        System.out.println("解法:" + count + "种");
        System.out.println("计算冲突:" + judgeCount + "次");
    }


}
