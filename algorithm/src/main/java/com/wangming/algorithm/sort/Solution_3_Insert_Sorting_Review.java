package com.wangming.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 描述：插入排序-复习
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
 */


public class Solution_3_Insert_Sorting_Review {

    /*
     * 描述：整理
     */
    public static void insertSortV2(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            //NO.1
            int temp = nums[i];
            int index = i - 1;
            while (index >= 0 && temp < nums[index]) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = temp;
        }
    }


    /*
     * 描述：逐步推导-不参考手写
     */
    public static void insertSortV1(int[] nums) {

        //NO.1
        int temp = nums[1];
        int index = 0;
        while (index >= 0 && temp < nums[index]) {
            nums[index + 1] = nums[index];
            index--;
        }
        nums[index + 1] = temp;

        //NO.2
        temp = nums[2];
        index = 1;
        while (index >= 0 && temp < nums[index]) {
            nums[index + 1] = nums[index];
            index--;
        }
        nums[index + 1] = temp;


        //NO.3
        temp = nums[3];
        index = 2;
        while (index >= 0 && temp < nums[index]) {
            nums[index + 1] = nums[index];
            index--;
        }
        nums[index + 1] = temp;
    }


    public static void main(String[] args) {

        int[] nums = {0, 2, 1, 4, 3, 5, 7, 6, 9, 8};

        int[] nums_2 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            nums_2[i] = (int) (Math.random() * 80000);//0~80000
        }
        System.out.println("————————————————————————————————————————————");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("排序前时间:" + simpleDateFormat.format(new Date()));//排序前时间:2019-09-12 09:40:56:360
        System.out.println("排序前:" + Arrays.toString(nums));
        insertSortV2(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
        System.out.println("排序后时间:" + simpleDateFormat.format(new Date()));//排序后时间:2019-09-12 09:40:57:144


    }

}
