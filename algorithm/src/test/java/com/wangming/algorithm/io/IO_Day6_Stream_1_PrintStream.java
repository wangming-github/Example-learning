package com.wangming.algorithm.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * 打印流
 */
public class IO_Day6_Stream_1_PrintStream {

    private static String fileName;

    @Before
    public void before() {
        fileName = "07.IO_Day6_Stream_1_PrintStream.txt";
    }


    @Test
    public void test1() {

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //true 表示自动刷新
        PrintStream printStream = new PrintStream(fileOutputStream, true);

        //指定打印流输出到文件"07.IO_Day6_Stream_PrintStream.txt" 中。
        System.setOut(printStream);

        //输出 ASCII字符
        for (int i = 0; i <= 255; i++) {
            System.out.print((char) i);
        }

        printStream.close();

    }

}
