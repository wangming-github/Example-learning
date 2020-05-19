package com.wangming.algorithm.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * 字节 字符 读文件
 */
public class IO_Day5_Test2_Input {


    //Q2:分别使用字节流 字符流 完成以下工作
    //读取"06.IO_Day5_Test.txt" 内容并且打印控制台

    public static String fileName;

    @Before
    public void before() {
        fileName = "06.IO_Day5_Test.txt";
    }


    //方法1 字节流
    @Test
    public void test5() {

        //不处理异常逻辑
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //byte[] bytes = new byte[215];
        //int read;
        //while ((read = bufferedInputStream.read(bytes)) != -1) {
        //    System.out.println(new String(bytes, 0, read));
        //}
        //bufferedInputStream.close();

        if (!new File(fileName).exists()) {
            System.out.println("文件不存在！");
        } else {
            BufferedInputStream bufferedInputStream = null;
            try {

                //new BufferedInputStream(new FileInputStream(new File(fileName)));
                bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
                byte[] bytes = new byte[215];
                int read;
                while ((read = bufferedInputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, read));
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
            }
        }
    }


    //方法1 字符流
    @Test
    public void test3() {

        //不处理异常逻辑
        //BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
        //String s;
        //while ((s = bufferedReader.readLine()) != null) {
        //    System.out.println(s);
        //}
        //bufferedReader.close();


        BufferedReader bufferedReader = null;
        try {

            //new BufferedReader(new FileReader(new File(fileName)));
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
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
}
