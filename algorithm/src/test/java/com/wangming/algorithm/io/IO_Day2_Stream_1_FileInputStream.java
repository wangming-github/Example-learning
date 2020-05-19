package com.wangming.algorithm.io;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 节点流
 * 字节流
 */
public class IO_Day2_Stream_1_FileInputStream {

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
     * 字节流      InputStream    FileInputStream(非文本,文本↓)      BufferedInputStream  ==> flush
     * 字节流      OutputStream   FileOutputStream(非文本,文本↓)     BufferedOutputStream ==> flush
     * 字符流      Reader         FileReader(文本)                  BufferedReader
     * 字符流      Writer         FileWriter(文本)                  BufferedWriter
     *
     * 生产使用缓存流可以提升文件操作效率
     *
     */


    /**
     * 功能描述: 从文件中读取数据
     * <p>
     * read() 读取的文件一定要存在 不然会报错
     * read() 读取一个文件的字节,当执行到文件结尾时返回-1 :[ABCDEFG] = A,B,C,D,E,F,G,-1
     */
    @Test
    public void Test1() throws IOException {

        //1.创建file对象
        String filePath = "01_demo.txt";
        File file = new File(filePath);

        //2.创建一个 FileInputStream 对象
        FileInputStream fileInputStream = new FileInputStream(file);

        //3.调用它的方法实现 file文件的读取
        //int b = fileInputStream.read(); //返回下一个数据的字节 或者是-1读完了
        //while (b != -1) {
        //    System.out.println((char) b);
        //    b = fileInputStream.read();
        //}

        // OR
        // ==> 换个写法

        int b;
        while ((b = fileInputStream.read()) != -1) {
            System.out.println((char) b);
        }

        //4.关闭流 Java IO流需要显式关闭
        fileInputStream.close();
    }


    /**
     * 功能描述: 从文件中读取数据 保证流的关闭操作
     * 使用try catch处理数据 流是一种稀有资源 throws出现异常就不会关闭正常的处理无论处理成功或者失败都要关闭
     */
    @Test
    public void Test2() {

        //1.创建file对象
        String filePath = "01_demo.txt";
        File file = new File(filePath);

        FileInputStream fileInputStream = null;
        try {
            //2.创建一个 FileInputStream 对象
            fileInputStream = new FileInputStream(file);
            //3.调用它的方法实现 file文件的读取
            int b;
            while ((b = fileInputStream.read()) != -1) {
                System.out.println((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流 Java IO流需要显式关闭
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 功能描述: 从文件中读取 字节数组
     */
    @Test
    public void Test3() {
        File file = new File("01_demo.txt");
        FileInputStream stream = null;
        try {

            stream = new FileInputStream(file);
            byte[] b = new byte[5];//读20个字节数据

            int len;//每次读入到byte的字节长度
            while ((len = stream.read(b)) != -1) {

                //for (byte b1 : b) {
                //    System.out.print((char) b1);
                //}

                //OR  ==>

                String s = new String(b, 0, len);
                System.out.println(s);

                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
