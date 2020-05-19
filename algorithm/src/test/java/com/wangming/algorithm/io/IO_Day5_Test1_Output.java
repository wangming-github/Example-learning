package com.wangming.algorithm.io;

import org.junit.Test;

import java.io.*;

/**
 * 字节 字符 写文件
 */
public class IO_Day5_Test1_Output {

    //Q1:分别使用字节流 字符流 完成以下工作
    //创建文件"06.IO_Day5_Test.txt" 并且写入以下内容：
    //转朱阁，低绮户，照无眠。不应有恨，何事长向别时圆？人有悲欢离合，月有阴晴圆缺，此事古难全。但愿人长久，千里共婵娟。


    //方法1 字节流实现内容的输出
    @Test
    public void test1_1() {

        String fileName = "06.IO_Day5_Test.txt";
        String str = "【BufferedOutputStream 字节流】\n 转朱阁，低绮户，照无眠。不应有恨，何事长向别时圆？\n 人有悲欢离合，月有阴晴圆缺，此事古难全。但愿人长久，千里共婵娟。";

        //不处理异常逻辑
        //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
        //bufferedOutputStream.write(str.getBytes());
        //bufferedOutputStream.flush();
        //bufferedOutputStream.close();


        BufferedOutputStream bufferedOutputStream = null;
        try {
            //new BufferedOutputStream(new FileOutputStream(new File(fileName)));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName));
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    //方法2 字符流
    @Test
    public void test2() {
        String fileName = "06.IO_Day5_Test.txt";
        String str = "【BufferedWriter 字符流】\n 转朱阁，低绮户，照无眠。不应有恨，何事长向别时圆? \n 人有悲欢离合，月有阴晴圆缺，此事古难全。但愿人长久，千里共婵娟。";

        //不处理异常逻辑
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        //bufferedWriter.write(str);
        //bufferedWriter.flush();
        //bufferedWriter.close();

        BufferedWriter bufferedWriter = null;
        try {

            //new BufferedWriter(new FileWriter(new File(fileName)));
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write(str);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
