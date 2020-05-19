package com.wangming.algorithm.dataStructure;

import org.junit.Test;

/**
 * 二维数组与稀疏数组的互相转化
 * 0   0   0   0   0   0   0   0   0   0   0
 * 0   0   1   0   0   0   0   0   0   0   0
 * 0   0   0   2   0   0   0   0   0   0   0
 * 0   0   0   0   0   0   0   0   0   0   0
 * 0   0   0   0   0   0   0   0   0   0   0
 * 0   0   0   0   0   0   2   0   0   0   0
 * 0   0   0   0   0   0   0   0   0   0   0
 * 0   0   0   0   0   0   0   0   0   0   0
 * 0   0   0   0   0   0   0   0   0   0   0
 * 0   0   0   0   0   0   0   0   0   0   0
 * 0   0   0   0   0   0   0   0   0   0   0
 *
 * @version V1.0
 * @auther MaiZi
 * @date 2019-07-23 14:48
 */
public class Day1_SparseArray_Test_1 {

    //五子棋
    @Test
    public void test() {

        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] chessArrays = new int[11][11];
        chessArrays[1][2] = 1;
        chessArrays[2][3] = 2;
        chessArrays[5][6] = 2;


        //将二维数组转为稀疏数组
        int[][] sparseArray = ArrayUtil.toSparseArray(chessArrays);
        //将稀疏数组转为二维数组
        int[][] array = ArrayUtil.toArray(sparseArray);


        //使用增强for循环输出原始二维数组
        System.out.println("原始二维数组如下:");
        ArrayUtil.printArray(chessArrays);

        System.out.println("稀疏数组如下:");
        ArrayUtil.printArray(sparseArray);

        System.out.println("将稀疏数组转为二维数组:");
        ArrayUtil.printArray(array);

    }
}
