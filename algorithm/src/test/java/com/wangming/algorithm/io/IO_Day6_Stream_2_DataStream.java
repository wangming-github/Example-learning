package com.wangming.algorithm.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * 数据流
 * 处理基本数据类型 String 字节数组
 */
public class IO_Day6_Stream_2_DataStream {

    private static String fileName;
    private static String content;

    @Before
    public void before() {
        fileName = "07.IO_Day6_Stream_2_DataStream.txt";
        content = "转朱阁，低绮户，照无眠。不应有恨，何事长向别时圆？人有悲欢离合，月有阴晴圆缺，此事古难全。但愿人长久，千里共婵娟。";
    }


    @Test
    public void output() {

        DataOutputStream dataOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            dataOutputStream = new DataOutputStream(fileOutputStream);

            //写入内容
            dataOutputStream.writeUTF(content);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeLong(122222222222L);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void input() {

        DataInputStream dataInputStream = null;
        try {

            FileInputStream fileInputStream = new FileInputStream(fileName);
            dataInputStream = new DataInputStream(fileInputStream);

            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readLong());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
