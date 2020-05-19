package com.wangming.algorithm.io;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机存取流
 * 1.既是输入流 又是输出流
 * 2.文件的任意位置读写
 */
public class IO_Day6_Stream_4_RandomAccessFile {


    //Q1:
    //读取 fileName 写入到 fileName_copy
    @Test
    public void test() {
        String fileName = "08.IO_Day6_Stream_4_RandomAccessFile.txt";
        String fileName_copy = "08.IO_Day6_Stream_4_RandomAccessFile_copy.txt";

        RandomAccessFile randomAccessFile_read = null;
        RandomAccessFile randomAccessFile_write = null;

        try {

            randomAccessFile_read = new RandomAccessFile(fileName, "r"); //r 读取
            randomAccessFile_write = new RandomAccessFile(fileName_copy, "rw");//rw 读写

            byte[] bytes = new byte[1024];
            int read;
            while ((read = randomAccessFile_read.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
                randomAccessFile_write.write(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile_read != null) {
                try {
                    randomAccessFile_read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile_write != null) {
                try {
                    randomAccessFile_write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //Q2:
    //读取 将 [ABCD] 覆盖 到fileName【10】位置后
    @Test
    public void test2() {
        String fileName = "08.IO_Day6_Stream_4_RandomAccessFile.txt";

        RandomAccessFile randomAccessFile_write = null;//rw 读写
        try {

            randomAccessFile_write = new RandomAccessFile(fileName, "rw");
            //seek 覆盖后续
            randomAccessFile_write.seek(10);
            randomAccessFile_write.write("[ABCD]".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile_write != null) {
                try {
                    randomAccessFile_write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Q2:
    //读取 将 ABCD 插入 到fileName 4 位置后 多行版
    //1、指针指向 4位置开始去读后面的内容并且保存在StringBuilder中
    //2、在4位置开始写要追加的字符，再将StringBuilder中的字符追加在其后
    //3、关闭流
    @Test
    public void test3() {

        String fileName = "08.IO_Day6_Stream_4_RandomAccessFile.txt";

        RandomAccessFile randomAccessFile_write = null;//rw 读写
        try {

            randomAccessFile_write = new RandomAccessFile(fileName, "rw");
            randomAccessFile_write.seek(4);

            byte[] bytes = new byte[1024];
            int read;
            StringBuilder stringBuffer = new StringBuilder();
            while ((read = randomAccessFile_write.read(bytes)) != -1) {
                stringBuffer.append(new String(bytes, 0, read));
            }

            randomAccessFile_write.seek(4);
            randomAccessFile_write.write("[test]".getBytes());
            randomAccessFile_write.write(stringBuffer.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile_write != null) {
                try {
                    randomAccessFile_write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
