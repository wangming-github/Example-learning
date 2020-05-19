package com.wangming.algorithm.dataStructure;

/**
 * @version V1.0
 * @auther MaiZi
 * @date 2019-07-23 18:01
 */
public class ArrayUtil {


    //***********************************************************
    //*********************将二维数组转为稀疏数组*********************
    //***********************************************************
    //1.遍历原始数组，得到有效数据个数。
    //2.根据个数创建稀疏数组
    //3.存储有效数据位置
    public static int[][] toSparseArray(int[][] arrays) {


        //1.遍历原始数组，得到有效数据个数。
        int sum = 0;
        for (int[] array : arrays) {
            for (int i : array) {
                if (i != 0) {
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        //sparseArray[行][列]
        sparseArray[0][0] = arrays.length;
        sparseArray[0][1] = arrays[0].length;
        sparseArray[0][2] = sum;

        //3.遍历二维数组将非0的值存放在稀疏数组中。
        int count = 0; //用于记录是第几个非0的数据
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = arrays[i][j];
                }
            }
        }

        return sparseArray;
    }


    //***********************************************************
    //*********************将稀疏数组转为二维数组*********************
    //***********************************************************
    public static int[][] toArray(int[][] sparseArray) {

        //1.先读取稀疏数据的第一行，并且按照第一列的数据创建二维数组，并分配大小。
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];

        //2.先读其他行的值 赋值给二维数组。
        for (int i = 1; i < sparseArray.length; i++) { //i = 1 排除第一行操作
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }

    //打印二维数组数组
    public static void printArray(int[][] array) {
        //输出下 稀疏数组
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.printf("\n");
        }
    }
}
