package com.wangming.algorithm.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * 字节 字符 复制文件
 */
public class IO_Day5_Test3_Copy {


    //Q2:分别使用字节流 字符流 完成以下工作
    //复制 "06.IO_Day5_Test.txt" 为  "06.IO_Day5_Test_copy.txt"

    private static String fileName;
    private static String fileNameCopy;
    private static String fileNameCopy_1;

    @Before
    public void before() {
        fileName = "06.IO_Day5_Test.txt";
        fileNameCopy = "06.IO_Day5_Test_copy.txt";
        fileNameCopy_1 = "06.IO_Day5_Test_copy_1.txt";
    }


    //方法1 字节流
    @Test
    public void test5() {

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        if (new File(fileName).exists()) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName)); //new BufferedInputStream(new FileInputStream(new File(fileName)));
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileNameCopy));//new FileOutputStream构造器可以直接传文件名
                byte[] bytes = new byte[1024];
                int read;
                while ((read = bufferedInputStream.read(bytes)) != -1) {

                    String s = new String(bytes, 0, read);
                    System.out.println(s);
                    bufferedOutputStream.write(s.getBytes());
                    bufferedOutputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

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
        } else {
            System.out.println("文件不存在！");
        }


    }


    //方法1 字符流
    @Test
    public void test3() {

        if (new File(fileName).exists()) {

            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(fileName));//等同于 new BufferedReader(new FileReader(new File(fileName)));
                bufferedWriter = new BufferedWriter(new FileWriter(fileNameCopy_1));//等同于 new BufferedWriter(new FileWriter(new File(fileNameCopy_1)));
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    System.out.println(s);
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

        } else {
            System.out.println("文件不存在!");
        }
    }
}
