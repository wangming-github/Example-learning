package com.wangming.algorithm.array;

import org.junit.Test;

/**
 * 一、二维数组
 * 1.二维数组的理解：由数组构成的数组就是二维数组。
 * 2.二维数组的使用。
 * ①二维数组的声明和初始化：[静态初始化 + 动态初始化]
 * ②如何调用数组指定位置的元素：[通过索引的方式调用]
 * ③如何获取数组长度：[length]
 * ④如何遍历数组元素。
 * ⑤数组元素的默认初始化值。
 * ⑥数组的内存解析
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-07-22 15:56
 */
public class Day1_Array_Test_2 {

    @Test
    public void test1() {

        //①二维数组的声明和初始化

        //静态初始化
        int[] ints = new int[]{1, 2, 3, 4}; //一维数组
        int[][] ints1 = new int[][]{{1, 2, 3}, {1, 2, 3, 4, 5}, {6, 7}}; //二维数组
        int[][] ints2 = {{1, 2, 3}, {1, 2, 3, 4, 5}, {6, 7}}; //类型推断

        //动态初始化
        String[][] strings = new String[3][2];//元素长度为2数，组长度为3的二维数组
        String[][] strings1 = new String[3][];//元素长度为未知，数组长度为3的二维数组
        String[] strings2[] = new String[3][];//元素长度为未知，数组长度为3的二维数组

        //②如何调用数组指定位置的元素：[通过索引的方式调用]
        System.out.println(ints2[0][2]);//3
        System.out.println(strings[0][1]);//null
        //System.out.println(strings[5][10]);//空指针异常

        //赋值
        int[][] ints3 = new int[3][];
        ints3[1] = new int[]{1, 2, 3};


        //③如何获取数组长度：[length] 指的是数组本身的长度和元素没有关系。
        System.out.println(ints1.length);//3


        //④如何遍历数组元素。
        for (int i = 0; i < ints1.length; i++) {
            for (int j = 0; j < ints1[i].length; j++) {
                System.out.print(ints1[i][j] + " ");
            }
            System.out.println();
        }


        //⑤数组元素的默认初始化值。
        //规定：外层数组元素，内层数组元素。
        // int[][] arr = new int[4][3];

        int[][] arr = new int[4][3];
        System.out.println(arr[0]);   //地址值: [I@4926097b  地址值只想栈 [：一维 ；I：int； @后是地址值
        System.out.println(arr[0][0]);// 0

        String[][] strings3 = new String[4][3];
        System.out.println(strings3[0]);   //地址值: [Ljava.lang.String;@762efe5d  地址值只想栈 [：一维 ；I：int； @后是地址值
        System.out.println(strings3[0][0]);//null


        double[][] doubles = new double[4][];//外层元素初始化值 null，内层 NullPointerException
        System.out.println(doubles[1]);   //null 栈中指向堆中的四个连续空间，但是每个空间都是存放引用类型的数据而且没有初始化，即默认值是null;
        System.out.println(doubles[1][0]);//NullPointerException


        //⑥数组的内存解析

    }


}





















