package com.wangming.algorithm.io;

import org.junit.Test;

import java.io.*;


public class IO_Day4_Stream_1_BufferedInput_OutputStream {


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


    //使用缓冲流实现非文本「文本文件也行 但是不建议」文件复制文件
    @Test
    public void test1() {

        String path1 = "01_demo.png";
        String path2 = "04_BufferedReader_BufferedWriter.png";

        copy_not_textfile(path1, path2);
    }


    public static void copy_not_textfile(String src, String dest) {
        //1.提供读入写出的文件
        File file1 = new File(src);
        File file2 = new File(dest);
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //2.提供相应的节点流
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            //3.将节点流对象作为形参传递到缓冲流的构造器中
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //4.具体文件的操作
            byte[] bytes = new byte[1024];

            int read;
            while ((read = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, read);
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //5.关闭流
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
