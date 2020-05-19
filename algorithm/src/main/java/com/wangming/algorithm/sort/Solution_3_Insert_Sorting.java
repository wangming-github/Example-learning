package com.wangming.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 描述：插入排序
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
 * 插入排序类似于我们打牌的时候对手中的牌进行排序的过程，具体过程为：插入排序会将数组分为“已排序部分”和“未排序部分”。首先将开头元素看成已经排序部分。然后执行取出未排序部分的头元素赋值给变量temp，将temp和已排序部分进行比较，比temp大的都向后挪一个单位，随后找出空位插入temp，一直循环这个操作直到未排序部分消失。
 * 插入排序是一种稳定排序，因为在排序中，我们只是将比v大的元素向后平移，不相邻的元素不会交换位置。
 * 总体来说插入排序是一种复杂度o(n^2)的算法，另
 * 外插入排序在处理相对有序的元素进行排序的时候效率是十分高的，因为元素相对有序那么元素移动的次数就会减少很多次，相应的效率也会提高。
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
 * 插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的。
 * 插入排序(Insertion Sorting)的基本思想是:
 * 把 n 个待排序的元素看成为一个有序表和一个无序表，
 * 开始时有 序表中只包含一个元素，无序表中包含有 n-1 个元素，
 * 排序过程中每次从无序表中取出第一个元素，
 * 把它的排 序码依次与有序表元素的排序码进行比较，
 * 将它插入到有序表中的适当位置，使之成为新的有序表。
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
 * 问题：
 * 有序程度较高 排序前:[2, 3, 4, 5, 9, 6],这时需要插入的数 6
 * 过程:[2, 3, 4, 5, 9, 9]
 * 有序程度较高 排序后:[2, 3, 4, 5, 6, 9]
 * ————————————————————————————————————————————————————————
 * 有序程度较低 排序前:[2, 3, 4, 5, 6, 1],这时需要插入的数 1(最小)
 * 过程:[2, 3, 4, 5, 6, 6]
 * 过程:[2, 3, 4, 5, 5, 6]
 * 过程:[2, 3, 4, 4, 5, 6]
 * 过程:[2, 3, 3, 4, 5, 6]
 * 过程:[2, 2, 3, 4, 5, 6]
 * 有序程度较低 排序后:[1, 2, 3, 4, 5, 6]
 * 结论:有序成都越高效率越高
 * ————————————————————————————————————————————————————————————————————————————————————————————————————
 *
 * @auther MaiZi
 * @date 2019-09-09 14:45
 */


public class Solution_3_Insert_Sorting {


    /*
     * 描述： 逐步推导
     * 插入排序类似于我们打牌的时候对手中的牌进行排序的过程，
     * 具体过程为：
     * 插入排序会将数组分为“已排序部分”和“未排序部分”。
     * 首先将开头元素看成已经排序部分。
     * 然后执行取出未排序部分的头元素赋值给变量temp，将temp和已排序部分进行比较，比temp大的都向后挪一个单位，随后找出空位插入temp，
     * 一直循环这个操作直到未排序部分消失。
     *
     * @auther MaiZi
     * @date 2019-09-09 16:11
     */
    public static void insertSortV1(int[] nums) {

        //第一轮  [[101], 34, 119, 1] ==>  [[34, 101], 119, 1]//1.首先将开头元素看成已经排序部分。
        int temp = nums[1];//2.然后执行取出未排序部分的头元素赋值给变量temp，
        int j = 1 - 1;
        while (j >= 0 && temp < nums[j]) {//3.将temp和已排序部分进行比较
            nums[j + 1] = nums[j];//4.比temp大的都向后挪一个单位
            j--;
        }
        nums[j + 1] = temp;//5.随后找出空位插入temp，

        /*
         * 描述：一直循环这个操作直到未排序部分消失。
         */

        //第二轮  [[34, 101], 119, 1] ==>  [[34, 101, 119], 1]
        temp = nums[2];
        j = 2 - 1;
        while (j >= 0 && temp < nums[j]) {
            nums[j + 1] = nums[j];
            j--;
        }
        nums[j + 1] = temp;//当退出while循环时  找到temp的位置

        //第三轮 [[34, 101, 119], 1]  ==>   [[1, 34, 101, 119]]
        temp = nums[3];
        j = 3 - 1;
        while (j >= 0 && temp < nums[j]) {
            nums[j + 1] = nums[j];
            j--;
        }
        nums[j + 1] = temp;//当退出while循环时  找到temp的位置
    }


    public static void insertSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
            System.out.println("第" + (i) + "轮:" + Arrays.toString(nums));
        }
    }


    public static void insertSortV2(int[] nums) {


        //第三轮 {2,3,4,5,9,6}  ==>  {2,3,4,5,6,9}
        int temp = nums[5];
        int j = 5 - 1;
        while (j >= 0 && temp < nums[j]) {
            nums[j + 1] = nums[j];
            System.out.println("过程:" + Arrays.toString(nums));
            j--;
        }
        nums[j + 1] = temp;//当退出while循环时  找到temp的位置
    }

    public static void main(String[] args) {

        int[] nums = {101, 34, 119, 1};

        int[] nums_2 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            nums_2[i] = (int) (Math.random() * 80000);//0~80000
        }
        System.out.println("————————————————————————————————————————————");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println("排序前时间:" + simpleDateFormat.format(new Date()));//排序前时间:2019-09-12 09:40:56:360
        System.out.println("排序前:" + Arrays.toString(nums));
        insertSort(nums);
        System.out.println("排序后:" + Arrays.toString(nums));
        System.out.println("排序后时间:" + simpleDateFormat.format(new Date()));//排序后时间:2019-09-12 09:40:57:144

        System.out.println("————————————————————————————————————————————");
        int[] nums_3 = {2, 3, 4, 5, 9, 6};
        int[] nums_4 = {2, 3, 4, 5, 6, 1};
        System.out.println("有序程度较高 排序前:" + Arrays.toString(nums_3));
        insertSortV2(nums_3);
        System.out.println("有序程度较高 排序后:" + Arrays.toString(nums_3));

        System.out.println("————————————————————————————————————————————");
        System.out.println("有序程度较低 排序前:" + Arrays.toString(nums_4));
        insertSortV2(nums_4);
        System.out.println("有序程度较低 排序后:" + Arrays.toString(nums_4));

    }

}
