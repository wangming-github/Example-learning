package com.wangming.algorithm.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class IO_Day4_Stream_2_Other {


    /*
     *************************************************
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
     *************************************************
     * JAVA IO体系
     *
     *            抽象基类         节点流（文件流）                    缓冲流
     * 字节流      InputStream    FileInputStream(非文本,文本↓)      BufferedInputStream ==> flush
     * 字节流      OutputStream   FileOutputStream(非文本,文本↓)     BufferedOutputStream ==> flush
     * 字符流      Reader         FileReader(文本)                  BufferedReader ==> readLine() ==>flush()
     * 字符流      Writer         FileWriter(文本)                  BufferedWriter ==> flush()
     *
     * 生产使用缓存流可以提升文件操作效率
     *
     *************************************************
     * 转换流 InputStreamReader OutputStreamWriter
     * 解码：字符串 => 字节数组
     * 编码：字节数组  => 字符串
     *
     */


    //转换流
    @Test
    public void test1() {
        String path3 = "01_demo.txt";
        String path4 = "05_InputStreamReader_OutputStreamWriter.txt";
        test(path3, path4);
    }


    // 如何实现字节流 与 字符流之间的转换？
    // 字节流 => 字符流
    // 字符流 => 字节流
    public static void test(String src, String dest) {


        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {

            /*
             * 解码
             */
            //1.提供读入写出的文件
            File file1 = new File(src);
            //2.使用字节型的输入流读取
            FileInputStream inputStream = new FileInputStream(file1);
            //3.将字节流包装成字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            //3.1.也可以将字符流继续包装成缓冲流
            bufferedReader = new BufferedReader(inputStreamReader);


            /*
             * 编码
             */
            File file2 = new File(dest);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }


    //@Test
    public static void test2() {
        BufferedReader bufferedReader = null;
        try {
            InputStream in = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            bufferedReader = new BufferedReader(inputStreamReader);

            String s;
            while (true) {
                System.out.println("输入:");
                s = bufferedReader.readLine();
                if (s.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(s.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        test2();
    }

}
