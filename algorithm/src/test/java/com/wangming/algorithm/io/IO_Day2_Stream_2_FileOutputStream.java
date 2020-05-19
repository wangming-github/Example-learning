package com.wangming.algorithm.io;


import javafx.scene.chart.Chart;
import org.junit.Test;

import java.io.*;


/**
 * 节点流
 * 字节流
 */
public class IO_Day2_Stream_2_FileOutputStream {

    /*
     *
     * 流的分类
     * 处理的单位来分: 字节流「视频 图片」
     *              字符流「文本文件」
     *
     * 流向来分: 输入流「文件->程序」
     *         输出流「程序->文件」
     *
     * 角色来分:  节点流「程序直接操作文件 共4个  FileInputStream; FileOutputStream; FileReader; FileWriter;」
     *          处理流「将节点流包一层处理的流 例如打印流 缓冲流」
     *
     * 抽象基类  字节流         字符流
     * 输入流   InputStream   Reader
     * 输出流   OutputStream  Writer
     *
     *
     * JAVA IO体系
     *
     *            抽象基类         节点流（文件流）                    缓冲流
     * 字节流      InputStream    FileInputStream(非文本,文本↓)      BufferedInputStream ==> flush
     * 字节流      OutputStream   FileOutputStream(非文本,文本↓)     BufferedOutputStream ==> flush
     * 字符流      Reader         FileReader(文本)                  BufferedReader
     * 字符流      Writer         FileWriter(文本)                  BufferedWriter
     *
     * 生产使用缓存流可以提升文件操作效率
     *
     */


    /**
     * 功能描述: 往文件写入数据
     * <p>
     * 写入的文件不一定要存在 没有就创建 若存在就将原有内容覆盖
     */
    @Test
    public void Test1() {

        //1.创建file对象
        String filePath = "02_FileOutputStream.txt";
        File file = new File(filePath);

        //2.创建一个 FileOutputStream 对象 并将file对象作为形参传递给该对象
        FileOutputStream fileOutputStream = null;
        try {

            fileOutputStream = new FileOutputStream(file);
            //3.写入
            String s = "与肝胆人共事，无字句处读书。";
            fileOutputStream.write(s.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 功能描述:从文件中读取数据 并 往写入另一个位置
     */
    @Test
    public void Test2() {

        String filePath1 = "01_demo.png";
        String filePath2 = "02_FileOutputStream.png";

        System.out.println(copyFile(filePath1, filePath2));
    }


    //文件复制方法
    public static boolean copyFile(String src, String dest) {
        //1.创建file对象
        String filePath1 = src;
        File file1 = new File(filePath1);

        //1.创建file对象
        String filePath2 = dest;
        File file2 = new File(filePath2);

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {

            inputStream = new FileInputStream(file1);
            outputStream = new FileOutputStream(file2);
            //实现文件的复制
            //每次读取的大小
            byte[] bytes = new byte[100];
            int read = 0;
            while ((read = inputStream.read(bytes)) != -1) {
                //outputStream.write(bytes);  //错误写法1
                //outputStream.write(bytes,0,bytes.length); //错误写法2
                outputStream.write(bytes, 0, read);//正确写法
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


}
