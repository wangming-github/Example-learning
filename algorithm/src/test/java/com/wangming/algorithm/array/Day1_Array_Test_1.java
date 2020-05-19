package com.wangming.algorithm.array;

import org.junit.Test;

/**
 * 一、数组的概览
 * 1.数组的理解：数组（Array），是相同类型的数据按照一定的顺序排列的集合。并且使用一个名字来命名。并且通过编号的方式对数据进行统一的管理。
 * <p>
 * 2.数组相关概念
 * >> 数组名
 * >> 元素
 * >> 索引(角标，下标)
 * >> 长度(元素的个数)
 * <p>
 * 3.数组的特点
 * 1>有序排列
 * 2>数组本身是引用数据类型的变量，但是元素是基本数据类型（int），或者是引用数据类型（String）。
 * 3>创建数组结构会在内存中开辟一整块连续的空间。（在内存开辟不连续的空间结构的例如:链表）
 * 4>数组长度一旦确定，就不能修改。
 * <p>
 * 4.数组的分类。
 * ① 按照维数 ：一维数组，二维数组。
 * ② 按照元素的类型：基本数据类型元素的数组，引用数据类型元素的数组。
 * <p>
 * <p>
 * 5.一维数组的使用。
 * ①一维数组的声明和初始化：[静态初始化 + 动态初始化]
 * ②如何调用数组指定位置的元素：[通过索引的方式调用]
 * ③如何获取数组长度：[length]
 * ④如何遍历数组元素。
 * ⑤数组元素的默认初始化值。
 * ⑥数组的内存解析:JVM-内存简化结构
 * |-----|      |----------------|
 * |  栈 |       |               |
 * |stack|      |    堆heap      |
 * |     |      |               |
 * |     |      |---------------|
 * |     |
 * |     |      |----------------|
 * |     |      |   方法区        |<<---包含常量池   静态域
 * |-----|      |---------------|
 * <p>
 * 栈（stack）  存放结构：局部变量（放在方法中的变量都叫局部变量）
 * 堆（heap）   存放结构：new出来的对象 数组
 * 常量池       存放结构：String
 * 静态域       存放结构：Static
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-07-22 15:56
 */
public class Day1_Array_Test_1 {

    //5.一维数组的使用。
    @Test
    public void Test1() {

        //①一维数组的声明和初始化: [静态初始化 + 动态初始化]
        //1.1.静态初始化：数组的初始化和数组元素的赋值操作同时进行；
        int[] ids = new int[]{1001, 1002, 1003, 1004};//初始化
        int[] ids1 = {1001, 1002, 1003, 1004};//类型推断


        //1.2.动态初始化：数组的初始化和数组元素的赋值操作分开进行；
        String[] names = new String[5];
        //总结：数组一旦初始化完成，其长度就确定了。

        //②如何调用数组指定位置的元素:通过索引的方式调用
        //数组的索引从0开始的，从数组的长度-1结束。
        names[0] = "张三";
        names[1] = "李四";
        names[2] = "王五";
        names[3] = "赵六";
        names[4] = "田七";//charAt(0); = 田； 和数据库有关的都是1开始。
        //names[5] = "孙八";//java.lang.ArrayIndexOutOfBoundsException: 5

        //③如何获取数组长度。
        System.out.println("names长度:" + names.length);
        System.out.println("ids长度:" + ids.length);

        //④如何遍历数组元素。
        //for (int i = 0; i < names.length; i++) {
        //    System.out.println("names :" + names[i]);
        //}

        //OR
        for (String name : names) {
            System.out.println("names :" + name);
        }

    }

    @Test
    public void test2() {

        //⑤数组元素的默认初始化值。没有赋值前的值。

        //基本数据类型
        // byte;short;long; 默认0
        // float;double;    默认0.0
        // char;            默认0或者 \\u000
        // boolean;         默认false

        //引用数据类型
        //String         默认null


        long[] arr1 = new long[4];
        for (long item : arr1) {
            System.out.println(item);
        }

        double[] arr2 = new double[4];
        for (double item : arr2) {
            System.out.println(item);
        }

        char[] arr3 = new char[4];
        for (char item : arr3) {
            System.out.println("char:" + item + ";");
        }

        boolean[] arr4 = new boolean[4];
        for (boolean item : arr4) {
            System.out.println(item);
        }

        String[] arr5 = new String[4];
        for (String item : arr5) {
            System.out.println(item);
        }
    }


    //⑥数组的内存解析
    @Test
    public void test3() {

    }

}





















