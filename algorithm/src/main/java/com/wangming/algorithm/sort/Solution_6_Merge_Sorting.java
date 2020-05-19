package com.wangming.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
 * 描述：归并排序
 * 归并排序(MERGE-SORT)是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治(divide-and-conquer) 策略(分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修 补"在一起，即分而治之)。
 *
 */

public class Solution_6_Merge_Sorting {


    //逐步推导
    //public static void mergeSort(int[] nums, int left, int mid, int right, int[] temp) {
    //
    //
    //}


    public static void main(String[] args) {

        int[] nums = {8, 4, 5, 7, 1, 3, 6, 2};
        //int[] nums_2 = new int[80000];
        //for (int i = 0; i < 80000; i++) {
        //    nums_2[i] = (int) (Math.random() * 80000);//0~80000
        //}

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("排序前时间:" + simpleDateFormat.format(new Date()));
        System.out.println("排序前:" + Arrays.toString(nums));
        //mergeSort(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
        System.out.println("排序后时间:" + simpleDateFormat.format(new Date()));
    }

}
