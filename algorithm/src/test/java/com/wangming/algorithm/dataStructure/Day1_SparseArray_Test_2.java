package com.wangming.algorithm.dataStructure;

import org.junit.Before;
import org.junit.Test;

import java.io.*;


/**
 * 3.1.4 课后练习
 * 要求:
 * 1) 将稀疏数组保存到磁盘上，比如 Day1_SparseArray_Test_2.txt
 * 2) 恢复原来的数组时，Day1_SparseArray_Test_2.txt 进行恢复
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-07-23 17:20:41
 */
public class Day1_SparseArray_Test_2 {

    //创建棋盘大小为:20*20
    int[][] array = new int[20][20];
    final String FILENAME = "09_Day1_SparseArray_Test_2.txt";
    final String TAB = "\t";

    //创建二维数组
    @Before
    public void createArray() {

        //动态赋值
        array[1][2] = 1;
        array[2][0] = 1;
        array[3][8] = 1;
        array[4][6] = 1;
        array[5][3] = 1;
        array[6][3] = 1;
        array[7][1] = 1;
        array[8][0] = 1;

        array[1][12] = 2;
        array[2][10] = 2;
        array[3][18] = 2;
        array[4][16] = 2;
        array[5][13] = 2;
        array[6][13] = 2;
        array[7][11] = 2;
        array[8][10] = 2;
    }


    //将二维数组转为稀疏数组保存在磁盘上
    @Test
    public void writeSparseArrayFile() {

        ArrayUtil.printArray(array);

        //将二维数组转为稀疏数组
        int[][] sparseArray = ArrayUtil.toSparseArray(array);

        System.out.println("--------------文件操作--------------");
        //创建文件
        File file = new File(FILENAME);
        System.out.println("删除 " + file.delete());
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("创建文件:" + FILENAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("--------------流操作--------------");
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            //循环稀疏数组
            for (int[] ints : sparseArray) {
                // 将稀疏数组每一行写入文件
                for (int data : ints) {
                    String strData = String.valueOf(data); //int ==>String
                    bufferedWriter.write(strData + TAB);//添加制表符
                }
                bufferedWriter.newLine(); //一行写完换行
                bufferedWriter.flush();//提交流
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //将存在磁盘上稀疏数组读取并转为二维数组
    @Test
    public void readerSparseArrayFile() {


        ArrayUtil.printArray(array);


        System.out.println("--------------文件操作--------------");
        File file = new File(FILENAME);
        if (!file.exists()) {
            System.out.println(FILENAME + "文件不存在,请先创建文件，并且写入稀疏数组....");
        }

        System.out.println("--------------流操作--------------");

        // 所以不用声明 BufferedReader 直接
        //LineNumberReader 是BufferedReader的子类，用来按行读取文本文件,而且LineNumberReader能获取当前行的行号。
        LineNumberReader lineNumberReaderMaxLine = null;
        BufferedReader bufferedReader = null;
        try {
            lineNumberReaderMaxLine = new LineNumberReader(new FileReader(file));
            bufferedReader = new BufferedReader(new FileReader(file));

            //获取行数创建稀疏数组
            lineNumberReaderMaxLine.skip(Long.MAX_VALUE);//跳过全文
            int lines = lineNumberReaderMaxLine.getLineNumber();//获取行号，实际上是读取换行符，即最后一行的行号
            int[][] sparseArray = new int[lines][3];
            System.out.println("刚创建好的稀疏数组:");
            ArrayUtil.printArray(sparseArray);

            //给稀疏数组赋值
            int row = 0;//数组索引从0开始
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sparseArray[row][0] = Integer.valueOf(line.split(TAB)[0]);
                sparseArray[row][1] = Integer.valueOf(line.split(TAB)[1]);
                sparseArray[row][2] = Integer.valueOf(line.split(TAB)[2]);
                row++;
            }

            System.out.println("赋值完成的稀疏数组:");
            ArrayUtil.printArray(sparseArray);

            System.out.println("稀疏数组转二维数组:");
            ArrayUtil.toArray(sparseArray);
            ArrayUtil.printArray(array);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (lineNumberReaderMaxLine != null) {
                try {
                    lineNumberReaderMaxLine.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
