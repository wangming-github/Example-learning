package com.wangming.algorithm.io;

import javafx.scene.chart.Chart;
import org.junit.Test;

import java.io.*;

/**
 * 节点流
 * 字符流
 */
public class IO_Day3_Stream_1_FileReader_FileWriter {



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


    @Test
    public void Test1() {
        String path = "01_demo.txt";
        File file = new File(path);

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] chars = new char[24];

            int read;
            while ((read = fileReader.read(chars)) != -1) {
                String s = new String(chars, 0, read);
                System.out.print(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //对于非文本文件「视频，音频，二进制文件」只能使用字节流;
    //对于文本文件可以使用字符流「FileReader，FileWriter」，字节流「InputStream，OutputStream」;
    @Test
    public void copy_only_textfile() {

        //1.创建file对象
        //必须存在
        String path1 = "01_demo.txt";
        File readerFile = new File(path1);

        //可以不存在
        String path2 = "03_FileReader_FileWriter.txt";
        File writerFile = new File(path2);

        //2.创建输入输出流
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {

            fileReader = new FileReader(readerFile);
            fileWriter = new FileWriter(writerFile);

            char[] charts = new char[24];
            int len;
            while ((len = fileReader.read(charts)) != -1) {
                fileWriter.write(charts, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
